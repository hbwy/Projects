package cms.model;

import java.util.Date;
import java.util.List;

public class Article {
    private int id; //���´���
    private String title;   //����
    private String content; //����
    private String source;  //��Դ
    private String author;  //����
    private String keyword; //�ؼ���
    private Channel channel;  //����Ƶ��
    private Date createTime;  //����ʱ��
    private Date updateTime;  //����ʱ��
    private Date publishTime; //����ʱ��
    private boolean headerLine;  //�Ƿ�ͷ��
    private boolean recommend;  //�Ƿ��Ƽ�
    private int clickScore;  //�����
    private int msgCount;  //������
    private List<Attachment> attachments; //����
    //��Ӹ���
    public void addAttachment(Attachment attachment){
    	attachments.add(attachment);
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public boolean isHeaderLine() {
		return headerLine;
	}
	public void setHeaderLine(boolean headerLine) {
		this.headerLine = headerLine;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	public int getClickScore() {
		return clickScore;
	}
	public void setClickScore(int clickScore) {
		this.clickScore = clickScore;
	}
	public int getMsgCount() {
		return msgCount;
	}
	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
    
}
