<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<% Article a = (Article)request.getAttribute("article");
 %>
<div id="left" style="text-align:left">
		首页 -&gt; <%=a.getChannel().getName() %> - <%=a.getTitle() %>
		<hr>
		<!-- 文章标题及简介 -->
		<div class="h2title"><%=a.getTitle()%></div>
		<div class="atime">
		点击量：<%=a.getClickScore() %>
		|作者： <%=a.getAuthor() %>
		| 来源：<%=a.getSource() %>
		| <%=a.getPublishTime() %>
		</div>
		<p>
        <%=a.getContent() %>
		</p>
		<!-- 关于留言 -->
		<jsp:include page="/site/MessageServlet">
	        <jsp:param value="list" name="m"/>
		</jsp:include>
</div>


 