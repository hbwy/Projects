<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<%List<Article> articles = (List<Article>)request.getAttribute("articles");
  PageModel pm = (PageModel)request.getAttribute("pagemodel");
 %>

<% for(int i=0;i<articles.size();i++){ 
	    Article a = articles.get(i);
%>
		<div class="h2title"><%=a.getTitle() %></div>
		<div CLASS="atime">
		<%=a.getAuthor() %>| <%=a.getSource() %>| <%=a.getPublishTime() %>
		</div>
		<%=(a.getContent()!=null)?((a.getContent().length()>200)?a.getContent().substring(0, 200):a.getContent()):"" %>
		<br/>
		<a href="article.jsp?articleId=<%=a.getId() %>">【阅读全文】</a>
<%} %>
<br/>
共有<%=pm.getTotalPages() %>条搜索结果&nbsp;&nbsp;&nbsp;&nbsp;
<%for(int i=1;i<=pm.getTotalPages();i++){ %>
    [<a href="topic.jsp?channelId=<%=request.getParameter("channelId") %>&pageNo=<%=i %>"><%=i %></a>]&nbsp;&nbsp;&nbsp;
<%} %>

 