<%@page import="cms.model.*,java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>会员自服务系统</title>
<style type="text/css">
<!--

h3 {
	font-size:14px;
	font-weight:bold;
}

pre,p {
	color:#1E7ACE;
	margin:4px;
}
input, select,textarea {
	padding:1px;
	margin:2px;
	font-size:12px;
}
.buttom{
	padding:1px 10px;
	font-size:12px;
	border:1px #1E7ACE solid;
	background:#D0F0FF;
}
#formwrapper {
	width:95%;
	margin:15px auto;
	padding:20px;
	text-align:left;
}

fieldset {
	padding:10px;
	margin-top:5px;
	border:0px solid #1E7ACE;
	background:#fff;
}

fieldset legend {
	color:#1E7ACE;
	font-weight:bold;
	background:#fff;
}

fieldset label {
	float:left;
	width:120px;
	text-align:right;
	padding:4px;
	margin:1px;
}

fieldset div {
	clear:left;
	margin-bottom:2px;
}

.enter{ text-align:center;}
.clear {
	clear:both;
}

-->
</style>
<script type="text/javascript">
function validate(form){
	if(form.newPassword.value != form.newPassword2.value){
		alert("您两次输入的新密码不一致，请重新输入！");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<!-- 网站的logo，其它背景，首页横幅广告等等 -->
<div id="top">
	<img src="../images/logo.gif" class="logo" title="领航致远JAVA联盟">
	<div class="bg">
	</div>
</div>
<!-- 首页中间 -->
	<!-- 首页左边 -->
	<div id="left" style="text-align:left">
		<!-- 导航条 -->
		<% Member m = (Member)request.getSession().getAttribute("LOGIN_MEMBER"); %>
		<a href="../site/MemberServlet?m=get&id=<%=m.getId()%>">个人中心首页</a>
		<hr>
<!-- 主界面 -->
<div class="h2title">修改个人密码</div>
	<div id="formwrapper">
		<form action="../site/MemberServlet?m=updatePassword" method="post" onsubmit="return validate(this);">
		<input type="hidden" name="id" value="<%=m.getId()%>">
		<fieldset>	
			<div>
				<label for="oldPassword">输入旧密码</label>
				<input type="text" name="oldPassword" id="oldPassword" value="" size="30" maxlength="200" /> 
				<br />	
			</div>
			<div>
				<label for="newPassword">输入新密码</label>
				<input type="text" name="newPassword" id="newPassword" value="" size="30" maxlength="100" /> 
				<br />	
			</div>
			<div>
				<label for="newPassword2">重复新密码</label>
				<input type="text" name="newPassword2" id="newPassword2" value="" size="30" maxlength="100" /> 
			</div>
			
			<div class="enter">
			    <input name="submit" type="submit" class="buttom" value="提交" />
			    <input name="reset" type="reset" class="buttom" value="重置" />
			</div>
		</fieldset>
		</form>
	</div>
</div>
</body>
</html>