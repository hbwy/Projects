<%@ page language="java" import="java.util.*,cms.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
PageModel pm = (PageModel)request.getAttribute("pageModel");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>CMS 后台管理工作平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
A:active,A:visited,A:link {
	COLOR: #0629FD;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: #FF6600;
	TEXT-DECORATION: none
}

A.relatelink:active,A.relatelink:visited,A.relatelink:link { 
	color: white;
	TEXT-DECORATION: none
}

A.relatelink:hover {
	COLOR: #FF6600;
	TEXT-DECORATION: none
}

td {
	font-size: 12px;
	color: #003366;
	height:24px
}

.STYLE1 a{
	COLOR: white;
}
.STYLE1 A:active,.STYLE1 A:visited,.STYLE1 A:link {
	COLOR: white;
	TEXT-DECORATION: none
}
.STYLE1 a:hover{
	COLOR: red;
}
-->
  </style>
  <script type="text/javascript">
       //跳到请求页
      function go(pageNo){
         document.getElementById("pageNo").value=pageNo; //设置提交的页号
         document.getElementById("f").submit();
      }
      //提交分页大小，显示第一页结果
      function selectPagesize(obj){
         document.getElementById("pageNo").value="1"; 
         document.getElementById("f").submit();
      }
  </script>
</head>
  
<body>
 <form action="../site/MessageServlet?m=articlelist" method="post" id="f">
   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
       <td height="30">
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td height="24" bgcolor="#353c44">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
               <tr>
                 <td>
                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
                     <tr>
                       <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                       <td width="94%" valign="bottom"><span class="STYLE1"> 网站文章列表</span></td>
                     </tr>
                   </table>
                 </td>
              </tr>
             </table>
            </td>
          </tr>
        </table>
      </td>
   </tr>
   <tr>
     <td>
         
          <b>关键字：
          </b>
          <input type="text" name="titleKey" value="<%=(request.getParameter("titleKey")==null)?"":request.getParameter("titleKey") %>"/>
          <input type="hidden" name="pageNo" id="pageNo" value="<%=(request.getParameter("pageNo")==null)?"1":(request.getParameter("pageNo")) %>" />
          <input type="button" value="检索" onclick="form_submit()"/>
     </td>
   </tr>
   <tr>
      <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
        <%List<Article> articles = (List<Article>)request.getAttribute("articles");  
        %>
          <tr>
             <td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">文章标题</span></div></td>
	         <td width="50" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">留言数</span></div></td>
	         <td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
          </tr>
		  <%    
		    for(int i=0;i<articles.size();i++){ 
		     Article a = articles.get(i);
		  %>
	      <tr>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><a href="../site/MessageServlet?m=backendlist&articleId=<%=a.getId() %>" title="点击查看文章留言"><%=a.getTitle() %></a></div></td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=a.getMsgCount() %></div></td>
	         <td height="20" bgcolor="#FFFFFF">
	            <div align="center" class="STYLE21">
	            	<a href="../site/MessageServlet?m=backendlist&articleId=<%=a.getId() %>" title="点击查看留言">查看留言</a>
	            </div>
	         </td>
	     </tr>
          <%} %>
       </table>
     </td>
   </tr>
   <tr>
     <td height="30">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td width="33%">
              <div align="left">
               <span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;
                                                      共有<strong><%=pm.getRowCount() %></strong> 篇文章，
                                                      当前第<strong><%=pm.getPageNo() %></strong> 页，
                                                      共 <strong><%=pm.getTotalPages() %></strong> 页
               </span>
              </div>
           </td>
           <td width="67%" align=right vAlign="center" noWrap>
				<%if(pm.getTotalPages()>1&&pm.getPageNo()!=1){ %>
				    <a href="javascript:go(1)">首页</a>
				<%}else{ %>
				       首页
				 <%} %>
				 
				<%if(pm.getTotalPages()>1&&pm.getPageNo()!=1){ %>
				    <a href="javascript:go(<%= pm.getPageNo()-1 %>)">上页</a>
				<%}else{ %>
				      上页
				<%} %>  
				
				<%for(int i=1;i<=pm.getTotalPages();i++){%>
				   <%if(i>=pm.getPageNo()-3 && i<=pm.getPageNo()+3){
					   if(pm.getPageNo()==i){%>
					      <a href="javascript:go(<%=i%>)"><font color="RED"><%=i %></font></a>  
					   <%}else{ %>
					      <a href="javascript:go(<%=i%>)"><%=i %></a>
					<%   }
					  }
				 }%>
				  
				<%if(pm.getTotalPages()>1&&pm.getPageNo()!=pm.getTotalPages()){ %>
				    <a href="javascript:go(<%= pm.getPageNo()+1 %>)">下页</a>
				<%}else{ %>
				      下页
				<%} %>
				
				<%if(pm.getTotalPages()>1&&pm.getPageNo()!=pm.getTotalPages()){ %>  
				    <a href="javascript:go(<%= pm.getTotalPages() %>)">尾页</a>
				<%}else{ %>
				      尾页
				<%} %>
				
				<select name="pageSize" onchange="selectPagesize(this)" >
				  <%for(int i=5;i<=50;i+=5){ %>	
					<option value="<%=i %>" <%=(pm.getPageSize()==i)?"selected":"" %> > <%=i %> </option>
				  <%} %>  
				</select>

           </td>
         </tr>
       </table>
     </td>
   </tr>
  </table>
  </form>
 </body>
</html>
