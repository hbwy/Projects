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
<title>��Աע��</title>
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
		alert("��������������");
		return false;
	}
	if(form.nickname.value.trim() == ""){
		alert("�����������ǳ�");
		return false;
	}
	if(form.password.value.trim() == ""){
		alert("��������������");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<!-- ������ -->
<div class="h2title">��Աע��</div>
<div id="formwrapper">
	<form action="../site/MemberServlet" method="post" onsubmit="validate(this);">
	<input type="hidden" name="m" value="register">
	<fieldset>
            <legend>������Ϣ</legend>
            <br/>
            <div>
                <label for="name">����</label>
                <input type="text" name="name" id="name" value="" size="30" maxlength="10" />
                *(���10���ַ�) <br/>
            </div>
            <br/>
            <div>
                <label for="nickname">�ǳ�</label>
                <input type="text" name="nickname" id="nickname" value="" size="30" maxlength="20" />
                *(���20���ַ�) <br/>
            </div>
            <br/>
            <div>
                <label for="password">����</label>
                <input type="text" name="password" id="password" value="" size="30" maxlength="20" />
                <br/>
            </div>
            <br/>
            <div>
                <label for="email">����</label>
                <input type="text" name="email" id="email" value="" size="30" maxlength="20" />
                <br/>
            </div>
            <br/>
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="�ύ">
                <input name="reset" type="reset" class="buttom" value="����">
            </div>
         </fieldset>
	</form>
</div>
</body>
</html>