<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CMS 后台管理工作平台</title>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<script type="text/javascript" src="js/js.js"></script>
	<script type="text/javascript">
		if(window.parent != window){
			window.parent.location = window.location;
		}
		function form_submit() {
			document.getElementById("login").submit();
		}
		function form_reset() {
			document.getElementById("login").reset();
		}
		function check(img) {
			img.src = "../checkcode.jpg?" + Math.random();
		}
	</script>
</head>
<body>
<div id="top"> </div>
<form id="login" action="LoginServlet?m=login" method="post">
  <div id="center">
    <div id="center_left"></div>
    <div id="center_middle">
      <div><font color="RED"><%=(request.getAttribute("error")==null)?"":request.getAttribute("error") %></font></div>
      <div class="user">
        <label>用户名：
        <input type="text" name="username" id="user" value="<%=(request.getParameter("username")==null)?"admin":request.getParameter("username") %>"/>
        </label>
      </div>
      <div class="user">
        <label>密　码：
        <input type="password" name="password" value="admin" id="pwd" value="" />
        </label>
      </div>

      <div class="chknumber">
        <label>验证码：
        <input name="checkcode" type="text" id="chknumber" maxlength="4" class="chknumber_input" />
        </label>
        <img src="../checkcode.jpg" id="safecode" onclick="check(this)" title="点击更换验证码" />
        
      </div>
      
      
    </div>
    <div id="center_middle_right"></div>
    <div id="center_submit">
      <div class="button"> <img src="images/dl.gif" width="57" height="20" onclick="form_submit()" > </div>
      <div class="button"> <img src="images/cz.gif" width="57" height="20" onclick="form_reset()"> </div>
    </div>
    <div id="center_right"></div>
  </div>
</form>
<div id="footer">北京领航致远科技有限公司</div>
</body>
</html>

