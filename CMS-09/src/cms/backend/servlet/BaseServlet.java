package cms.backend.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cms.utils.BeanFactory;
import cms.utils.SystemContext;

public class BaseServlet extends HttpServlet {
	protected BeanFactory beanFactory = null;
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html");
		beanFactory = (BeanFactory) this.getServletContext().getAttribute(InitBeanFactoryServlet.INIT_FACTORY_NAME);
		//利用反射调用Servlet的setter方法
		Method methods[] = this.getClass().getMethods();
		for(Method m:methods){
			if(m.getName().substring(0, 3).equals("set")){  //取得property的名字
				String methodName = m.getName().substring(3);
				methodName = methodName.substring(0, 1).toLowerCase()+methodName.substring(1);
				Object bean = beanFactory.getBean(methodName);  //从bean工厂拿出对应的bean
				try {
					m.invoke(this, bean);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		// 进行中转和分发
		String m = request.getParameter("m");
		if (m == null || m.equals("")) {
			m = "list";
		}
		// 获得一个方法对象
		try {
			//把分页pm放到ThreadLocal中
			SystemContext.setLocal(request);
			//判断是否multipart编码类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){ //如果是上传文件
				request = new MultipartRequestWrapper(request);
			}
			Method method = this.getClass().getMethod(m,HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			//方法调用完成,清除SystemContext中的分页信息
			SystemContext.removePM();
		}
	}

}
