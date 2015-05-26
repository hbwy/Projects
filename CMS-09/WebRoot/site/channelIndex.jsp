<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<%
  List<Article> articles = (List<Article>)request.getAttribute("articles"); 
  Channel channel = (Channel)request.getAttribute("channel");
%>
<div class="index_topic">
			<img src="images/jiantou.gif" style="float:left">
			<span style="margin-top:8px;float:left;FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #852b2b; FONT-FAMILY: ËÎÌו;"><%=channel.getName() %></span>
			<a href="topic.jsp?channelId=<%=channel.getId() %>"><img src="images/more_gray.gif" style="float:right;border:0px"></a>
			<%for(int i=0;i<articles.size();i++) {
				Article a = articles.get(i);
			%>
			<div class="index_topic_list">
				<img src="images/h_article.gif" >
				<a href="article.jsp?articleId=<%=a.getId() %>" title="<%=a.getTitle() %>"><%=a.getTitle() %></a>
				<%if(a.getPublishTime() != null){ %>
					<span>[<%=DateConverter.format(a.getPublishTime(),"yyyy-MM-dd" ) %>]</span>
				<%} %>
			</div>
			<%} %>
</div>
