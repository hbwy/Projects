<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<% Article a = (Article)request.getAttribute("article");
 %>
<div id="left" style="text-align:left">
		��ҳ -&gt; <%=a.getChannel().getName() %> - <%=a.getTitle() %>
		<hr>
		<!-- ���±��⼰��� -->
		<div class="h2title"><%=a.getTitle()%></div>
		<div class="atime">
		�������<%=a.getClickScore() %>
		|���ߣ� <%=a.getAuthor() %>
		| ��Դ��<%=a.getSource() %>
		| <%=a.getPublishTime() %>
		</div>
		<p>
        <%=a.getContent() %>
		</p>
		<!-- �������� -->
		<jsp:include page="/site/MessageServlet">
	        <jsp:param value="list" name="m"/>
		</jsp:include>
</div>


 