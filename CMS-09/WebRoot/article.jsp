<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>����</title>
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
	 <jsp:include page="/site/IndexServlet">
		   <jsp:param value="article" name="m"/>
	 </jsp:include>
		<!-- ��ҳ�ұ� -->
    <%@include file="/site/search.jsp" %>
    
	<jsp:include page="/site/IndexServlet">
		   <jsp:param value="related" name="m"/>
		   <jsp:param value="1" name="pageNo"/>
   		   <jsp:param value="4" name="pageSize"/>
	 </jsp:include>
	<div style="clear:both"></div>
</div>
<!-- ��ҳ�²�����Ȩ��Ϣ�ȵ� -->
     <%@include file="/site/footer.jsp" %>
</body>
</html>