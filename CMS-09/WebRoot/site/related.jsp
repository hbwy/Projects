<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<%List<Article> articles = (List<Article>)request.getAttribute("articles"); %>
<div class="right" style="height:200px">
		<div class="right_topic_1">
			оЮ╧ьндуб
		</div>
		<div class="right_topic_2">
			<a href="#"><img src="images/more_red.gif" style="float:right;margin-top:10px;border:0px"></a>
		</div>
		<%for(int i=0;i<articles.size();i++){ 
		     Article a = articles.get(i);
		%>
		<div class="right_topic_3">
			║╓ <a href="article.jsp?articleId=<%=a.getId() %>"><%=a.getTitle().length()>15?a.getTitle().substring(0, 15):a.getTitle() %></a>
		</div>
		<%} %>
</div>

