<%@ page language="java" import="java.util.*,cms.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸�Ƶ��</title>
    
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
    <% Channel c=(Channel)request.getAttribute("channel");%>
    <div id="formwrapper">
         <h3>�༭��վƵ��</h3>
         <form action="ChannelServlet?m=modify" method="post">
         <input type="hidden" name="method" value="add" />
         <fieldset>
            <legend>Ƶ��������Ϣ</legend>
            <input type="hidden" name="id" id="id" value="<%=c.getId() %>" />
            <div>
                <label for="id">Ƶ������</label>
                <input type="text" name="id1" id="id1" value="<%=c.getId() %>" size="60" maxlength="20" disabled/>
                *(���20���ַ�) <br/>
            </div>
            <div>
                <label for="name">Ƶ������</label>
                <input type="text" name="name" id="name" value="<%=c.getName() %>" size="60" maxlength="200" />
                *(���200���ַ�) <br/>
            </div>
            <div>
                <label for="description">Ƶ������</label>
                <textarea rows="20" cols="100" name="description"><%=c.getDescription() %></textarea>
                <br />
            </div>
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="�޸�">
                <input name="reset" type="reset" class="buttom" value="����">
            </div>
         </fieldset> 
         </form>
        
     </div>
  </body>
</html>
