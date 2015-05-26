<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>文章</title>
</head>
<body>
<!-- 网站的logo，其它背景，首页横幅广告等等 -->
     <%@include file="/site/header.jsp" %>
<!-- 首页的导航条 -->
	 <jsp:include page="/site/IndexServlet">
		   <jsp:param value="nav" name="m"/>
	 </jsp:include>
<!-- 首页中间 -->
<div id="mid">
	<!-- 首页左边 -->
	 <jsp:include page="/site/IndexServlet">
		   <jsp:param value="article" name="m"/>
	 </jsp:include>
		<!-- 首页右边 -->
    <%@include file="/site/search.jsp" %>
    
	<jsp:include page="/site/IndexServlet">
		   <jsp:param value="related" name="m"/>
		   <jsp:param value="1" name="pageNo"/>
   		   <jsp:param value="4" name="pageSize"/>
	 </jsp:include>
	<div style="clear:both"></div>
</div>
<!-- 首页下部，版权信息等等 -->
     <%@include file="/site/footer.jsp" %>
</body>
</html>