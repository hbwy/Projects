<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CMS ��̨������ƽ̨</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script language="javascript">
	jQuery().ready(function(){
		jQuery('#navigation').accordion({
			header: '.head',
			event: 'click',
			fillSpace: true,
			animated: 'bounceslide'
		});
	});
</script>
<style type="text/css">
<!--
body {
	margin:0px;
	padding:0px;
	font-size: 12px;
}
#navigation {
	margin:0px;
	padding:0px;
	width:147px;
}
#navigation a.head {
	cursor:pointer;
	background:url(images/main_34.gif) no-repeat scroll;
	display:block;
	font-weight:bold;
	margin:0px;
	padding:5px 0 5px;
	text-align:center;
	font-size:12px;
	text-decoration:none;
}
#navigation ul {
	border-width:0px;
	margin:0px;
	padding:0px;
	text-indent:0px;
}
#navigation li {
	list-style:none; display:inline;
}
#navigation li li a {
	display:block;
	font-size:12px;
	text-decoration: none;
	text-align:center;
	padding:3px;
}
#navigation li li a:hover {
	background:url(images/tab_bg.gif) repeat-x;
		border:solid 1px #adb9c2;
}
-->
</style>
</head>
<body>
<div  style="height:100%;">
  <ul id="navigation">
    <li> <a class="head">���¹���</a>
      <ul>
        <li><a href="ArticleServlet?m=list" target="rightFrame">��ѯ����</a></li>
        <li><a href="ArticleServlet?m=addInput" target="rightFrame">�������</a></li>
        <li><a href="../site/MessageServlet?m=articlelist" target="rightFrame">���Թ���</a></li>
      </ul>
    </li>
    <li> <a class="head">Ƶ������</a>
      <ul>
        <li><a href="ChannelServlet?m=list" target="rightFrame">��ѯƵ��</a></li>
        <li><a href="channel/add_channel.jsp" target="rightFrame">���Ƶ��</a></li>
      </ul>
    </li>
    <li> <a class="head">�������</a>
      <ul>
        <li><a href="#" target="rightFrame">�趨�������</a></li>
        <li><a href="#" target="rightFrame">�������¹���</a></li>
      </ul>
    </li>
    <li> <a class="head">��Ա����</a>
      <ul>
        <li><a href="MemberAdminServlet?m=query" target="rightFrame">��Ա����</a></li>
      </ul>
    </li>
    <li> <a class="head">ϵͳ����</a>
      <ul>
        <li><a href="#" target="rightFrame">�޸Ĺ���Ա����</a></li>
        <li><a href="#" target="rightFrame">�޸����ݿ�����</a></li>
        <li><a href="#" target="rightFrame">������վ����</a></li>
        <li><a href="#" target="rightFrame">������վ����</a></li>
      </ul>
    </li>
  </ul>
</div>
</body>
</html>

