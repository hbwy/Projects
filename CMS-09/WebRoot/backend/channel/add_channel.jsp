<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ƶ������</title>
    
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
         <h3>�����վƵ��</h3>
         <form action="ChannelServlet?m=add" method="post">
         <input type="hidden" name="method" value="add" />
         <fieldset>
            <legend>Ƶ��������Ϣ</legend>
            <div>
                <label for="id">Ƶ������</label>
                <input type="text" name="id" id="id" value="" size="60" maxlength="20" />
                *(���20���ַ�) <br/>
            </div>
            <div>
                <label for="name">Ƶ������</label>
                <input type="text" name="name" id="name" value="" size="60" maxlength="200" />
                *(���200���ַ�) <br/>
            </div>
            <div>
                <label for="description">Ƶ������</label>
                <textarea rows="20" cols="100" name="description"></textarea>
                <br />
            </div>
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="�ύ">
                <input name="reset" type="reset" class="buttom" value="����">
            </div>
         </fieldset> 
         </form>
        
     </div>
  </body>
</html>
