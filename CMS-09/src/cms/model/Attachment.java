package cms.model;

import java.util.Date;

public class Attachment {
	public static final String ATTACHMENT_DIR = "d:/temp/";
	private int id;
	private String name; //附件名,全路径名
	private int articleId; //对应的文章ID
	private String contentType; //附件类型
	private Date uploadTime; //上传时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
}
