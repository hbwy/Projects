<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/site/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>会员注册</title>
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
	
	if(form.name.value.trim() == ""){
		alert("您必须输入姓名");
		return false;
	}
	if(form.nickname.value.trim() == ""){
		alert("您必须输入昵称");
		return false;
	}
	if(form.password.value.trim() == ""){
		alert("您必须输入密码");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<!-- 主界面 -->
<div class="h2title">会员注册</div>
<div id="formwrapper">
	<form action="../site/MemberServlet" method="post" onsubmit="validate(this);">
	<input type="hidden" name="m" value="register">
	<fieldset>
            <legend>基本信息</legend>
            <br/>
            <div>
                <label for="name">姓名</label>
                <input type="text" name="name" id="name" value="" size="30" maxlength="10" />
                *(最多10个字符) <br/>
            </div>
            <br/>
            <div>
                <label for="nickname">昵称</label>
                <input type="text" name="nickname" id="nickname" value="" size="30" maxlength="20" />
                *(最多20个字符) <br/>
            </div>
            <br/>
            <div>
                <label for="password">密码</label>
                <input type="text" name="password" id="password" value="" size="30" maxlength="20" />
                <br/>
            </div>
            <br/>
            <div>
                <label for="email">邮箱</label>
                <input type="text" name="email" id="email" value="" size="30" maxlength="20" />
                <br/>
            </div>
            <br/>
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="提交">
                <input name="reset" type="reset" class="buttom" value="重置">
            </div>
         </fieldset>
	</form>
</div>
</body>
</html>