package cms.model;

import java.util.Date;
import java.util.List;

public class Article {
    private int id; //文章代码
    private String title;   //标题
    private String content; //内容
    private String source;  //来源
    private String author;  //作者
    private String keyword; //关键字
    private Channel channel;  //所属频道
    private Date createTime;  //创建时间
    private Date updateTime;  //更新时间
    private Date publishTime; //发布时间
    private boolean headerLine;  //是否头条
    private boolean recommend;  //是否推荐
    private int clickScore;  //点击量
    private int msgCount;  //留言数
    private List<Attachment> attachments; //附件
    //添加附件
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
