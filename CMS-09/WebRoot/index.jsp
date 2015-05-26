<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>欢迎访问领航致远JAVA联盟</title>
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
	<div id="left">
		<!-- 首页图片及首页文章标题、简介 -->
		<jsp:include page="/site/IndexServlet">
   			<jsp:param value="headline" name="m"/>
   			<jsp:param value="1" name="pageNo"/>
   			<jsp:param value="2" name="pageSize"/>
        </jsp:include>
		<!-- 底下是专题或频道的文章标题列表 -->
		<jsp:include page="/site/IndexServlet">
   			<jsp:param value="channelIndex" name="m"/>
   			<jsp:param value="1001" name="channelId"/>
        </jsp:include>
        <jsp:include page="/site/IndexServlet">
   			<jsp:param value="channelIndex" name="m"/>
   			<jsp:param value="1002" name="channelId"/>
        </jsp:include>
        <jsp:include page="/site/IndexServlet">
   			<jsp:param value="channelIndex" name="m"/>
   			<jsp:param value="1003" name="channelId"/>
        </jsp:include>
        <jsp:include page="/site/IndexServlet">
   			<jsp:param value="channelIndex" name="m"/>
   			<jsp:param value="1004" name="channelId"/>
        </jsp:include>
        
	</div>
	<!-- 首页右边 -->
	<jsp:include page="/site/userlogin.jsp"></jsp:include>
	<%@include file="/site/search.jsp" %>
    <jsp:include page="/site/IndexServlet">
   			<jsp:param value="recommend" name="m"/>
   			<jsp:param value="1" name="pageNo"/>
   			<jsp:param value="4" name="pageSize"/>
    </jsp:include>
	<jsp:include page="/site/IndexServlet">
   			<jsp:param value="publish" name="m"/>
   			<jsp:param value="1" name="pageNo"/>
   			<jsp:param value="4" name="pageSize"/>
    </jsp:include>
    <!-- <%@include file="/site/technology.jsp" %> -->
	<div style="clear:both"></div>
</div>
<!-- 首页下部，版权信息等等 -->
<%@include file="/site/footer.jsp" %>
</body>
</html>