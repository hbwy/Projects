<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>频道管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div id="formwrapper">
         <h3>添加网站频道</h3>
         <form action="ChannelServlet?m=add" method="post">
         <input type="hidden" name="method" value="add" />
         <fieldset>
            <legend>频道基本信息</legend>
            <div>
                <label for="id">频道代码</label>
                <input type="text" name="id" id="id" value="" size="60" maxlength="20" />
                *(最多20个字符) <br/>
            </div>
            <div>
                <label for="name">频道名称</label>
                <input type="text" name="name" id="name" value="" size="60" maxlength="200" />
                *(最多200个字符) <br/>
            </div>
            <div>
                <label for="description">频道描述</label>
                <textarea rows="20" cols="100" name="description"></textarea>
                <br />
            </div>
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="提交">
                <input name="reset" type="reset" class="buttom" value="重置">
            </div>
         </fieldset> 
         </form>
        
     </div>
  </body>
</html>
