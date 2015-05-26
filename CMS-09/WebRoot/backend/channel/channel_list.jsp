<%@ page language="java" import="java.util.*,cms.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'channel_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
	<!--
	.STYLE10 {color: #000000; font-size: 12px; }
	.STYLE6 {color: #000000; font-size: 12; }
	.STYLE19 {color: #344b50; font-size: 12px; }
	.STYLE21 {color: #3b6375; font-size: 12px; }
	-->
	</style>
	
    <script type="text/javascript">
		
			function del(id){
				if(confirm("确认要删除吗?")){
					var url="<%=basePath%>ChannelServlet?m=del&id="+id;
					window.location.href=url;
				}
			}
	</script>
  </head>
  
  <body>
    <% List<Channel> channels = (List<Channel>)request.getAttribute("channels"); %>
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
   	<tr>
   		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">频道代码</span></div></td>
   		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">频道名称</span></div></td>
   		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">频道描述</span></div></td>
   		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">操作</span></div></td>
   	</tr>
   	<% for(Channel c:channels){ %>
   		<tr>
   		<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=c.getId() %></div></td>
   		<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=c.getName() %></div></td>
   		<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=c.getDescription() %></div></td>
   		<td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">
	   		<a href="ChannelServlet?m=get&id=<%=c.getId() %>">编辑</a>  | 
	   		<a href="javascript:del('<%=c.getId() %>')">删除</a>
	   		</div>
	    </td>
   	</tr>
   	<%} %>
   </table>
  </body>
</html>
