<%@page import="cms.model.*,java.util.*" pageEncoding="GB18030"%>
<% List<Channel> channels = (List<Channel>)request.getAttribute("channels"); %>
<div id="nav">
	<div id="menu">
		<a href="index.jsp">��ҳ</a>
		<%for(int i=0;i<channels.size();i++){ %>
           <a href="topic.jsp?channelId=<%=channels.get(i).getId() %>"><%=channels.get(i).getName() %></a>
        <%} %>
		<a href="#">��̳</a>
	</div>
</div>
