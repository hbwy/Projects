<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<%List<Article> articles = (List<Article>)request.getAttribute("articles"); %>

<div style="width:100%;border:0px;text-align: left;">
	<img style="float:left;width:200px;height:200px;" src="images/earth.jpg">
	<% for(int i=0;i<articles.size();i++){ 
	    Article a = articles.get(i);
	%>
	   <h4>║╬<%=a.getTitle() %>║©</h4>
	   <p><b>дзхщё╨</b><%=(a.getContent()!=null)?((a.getContent().length()>200)?a.getContent().substring(0, 200):a.getContent()):"" %></p>
	        <a href="article.jsp?articleId=<%=a.getId() %>">║╬тд╤ах╚нд║©</a>
	<%} %>		
</div>

 