<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="cms.backend.dao.impl.*,cms.model.*" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
	ChannelDaoForIBatisImpl cd = new ChannelDaoForIBatisImpl();
   Channel c = cd.get(request.getParameter("channelId"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>��ӭ�����캽��ԶJAVA���ˡ�<%=c.getName() %>��</title>
</head>
<body>
<!-- ��վ��logo��������������ҳ������ȵ� -->
<%@include file="/site/header.jsp" %>
<!-- ��ҳ�ĵ����� -->
		<jsp:include page="/site/IndexServlet">
		   <jsp:param value="nav" name="m"/>
		</jsp:include>
<!-- ��ҳ�м� -->
<div id="mid">
	<!-- ��ҳ��� -->
	<div id="left" style="text-align:left">
		��ҳ -&gt<%=c.getName() %> 
		<hr>
		<!-- ���±��⼰��� -->
       <jsp:include page="/site/IndexServlet">
   			<jsp:param value="topic" name="m"/>
       </jsp:include>
	</div>
	<!-- ��ҳ�ұ� -->
	    <%@include file="/site/search.jsp" %>
	    <jsp:include page="/site/IndexServlet">
	   			<jsp:param value="recommend" name="m"/>
	   			<jsp:param value="1" name="pageNo"/>
	   			<jsp:param value="4" name="pageSize"/>
	    </jsp:include>
	
		<div style="clear:both"></div>
</div>
<!-- ��ҳ�²�����Ȩ��Ϣ�ȵ� -->
		<%@include file="/site/footer.jsp" %>
</body>
</html>