package cms.backend.servlet;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import cms.model.Attachment;

public class MultipartRequestWrapper extends HttpServletRequestWrapper {

	private Map allParams; // 定义Map,存request参数

	public MultipartRequestWrapper(HttpServletRequest request) {
		super(request);
		// 首先判断是否multipart编码类型
		// 如果是multipart编码类型，就逐个从request中取出各个表单域
		// 如果表单域是普通的表单域，则将它的值取出，放到allParams中
		// 如果表单域是文件，则
		// 1、把文件先存储到磁盘的某个目录中！
		// 2、把文件的有关信息（名称，类型，上传时间）包装成Attachment[]类型
		// 3、把包装好的Attachment[]类型，放到allParams中
		try {
			//判断是否multipart编码类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (!isMultipart) {
				// 不是multipart编码类型,说明是普通表单,则不做包装
				allParams = request.getParameterMap();
			} else {
				allParams = new HashMap();
				ServletFileUpload upload = new ServletFileUpload();
				// 得到请求参数的迭代器
				FileItemIterator iter = upload.getItemIterator(request);
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					// 得到表单域的名称
					String name = item.getFieldName();
					// 得到表单域的值（这是一个输入流）
					InputStream stream = item.openStream();
					if (item.isFormField()) {// 如果是普通表单域
						String value = Streams.asString(stream,request.getCharacterEncoding());
						//把普通表单域添加到map中
						addFieldsAndValuesToMap(name, value);
					} else { // 如果是文件
						if (stream.available() != 0) {// 如果文件域没有选择文件，则忽略处理
							String filename = item.getName(); // 得到上传的文件名称
							if (filename != null) {
								// 因为在IE下面，上传的文件还包含有此文件在客户端机器的路径
								// 所以，要把这个路径去掉，只取文件名
								filename = FilenameUtils.getName(filename);
							}
							// 将上传文件的输入流输出到磁盘的文件上
							Streams.copy(stream, new FileOutputStream(
									Attachment.ATTACHMENT_DIR + filename), true);

							Attachment attachment = new Attachment();
							attachment.setContentType(item.getContentType());
							attachment.setName(filename);
							attachment.setUploadTime(new Date());
							//把附件类对象添加到map中
							addFieldsAndValuesToMap(name, attachment);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//把普通表单域添加到map中
	private void addFieldsAndValuesToMap(String name, String value) {
		String[] fieldValues = (String[]) allParams.get(name);
		if (fieldValues == null) {
			allParams.put(name, new String[] { value });
		} else {
			fieldValues = Arrays.copyOf(fieldValues, fieldValues.length + 1);
			fieldValues[fieldValues.length - 1] = value;
			allParams.put(name, fieldValues);
		}
	}
	//把附件类对象添加到map中
	private void addFieldsAndValuesToMap(String name, Attachment value) {
		Attachment[] fieldValues = (Attachment[]) allParams.get(name);
		if (fieldValues == null) {
			allParams.put(name, new Attachment[] { value });
		} else {
			fieldValues = Arrays.copyOf(fieldValues, fieldValues.length + 1);
			fieldValues[fieldValues.length - 1] = value;
			allParams.put(name, fieldValues);
		}
	}

	@Override
	public String getParameter(String name) {
		String[] values = (String[]) allParams.get(name);
		if (values != null) {
			return values[0];
		}
		return null;
	}

	@Override
	public Map getParameterMap() {
		return allParams;
	}

}
