package cms.model;

import java.util.Date;

public class Attachment {
	public static final String ATTACHMENT_DIR = "d:/temp/";
	private int id;
	private String name; //������,ȫ·����
	private int articleId; //��Ӧ������ID
	private String contentType; //��������
	private Date uploadTime; //�ϴ�ʱ��
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
