<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>��ӭ�����캽��ԶJAVA����</title>
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
	<div id="left">
		<!-- ��ҳͼƬ����ҳ���±��⡢��� -->
		<jsp:include page="/site/IndexServlet">
   			<jsp:param value="headline" name="m"/>
   			<jsp:param value="1" name="pageNo"/>
   			<jsp:param value="2" name="pageSize"/>
        </jsp:include>
		<!-- ������ר���Ƶ�������±����б� -->
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
	<!-- ��ҳ�ұ� -->
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
<!-- ��ҳ�²�����Ȩ��Ϣ�ȵ� -->
<%@include file="/site/footer.jsp" %>
</body>
</html>