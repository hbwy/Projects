<%@ page language="java" import="java.util.*,cms.model.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>CMS ��̨������ƽ̨</title>
    
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
  
  
 	 //ȫѡ
      function checkedAll(){
        var checkItems = document.getElementsByName("checkItem");
          for(var i=0;i<checkItems.length;i++){
             checkItems[i].checked=document.getElementById("checkAll").checked;
         } 
      }
      
      //����ɾ
      function delBatch(){
         if(confirm("ȷ��Ҫ����ɾ����")){
             document.getElementById("pageNo").value="1";
	         document.getElementById("f").action="ArticleServlet?m=delBatch";
	         document.getElementById("f").submit();
         }
      }
      
      
      //��ɾ
      function del(url){
         if(confirm("ȷ��Ҫɾ����")){
	         document.getElementById("f").action=url; //����form����action
	         document.getElementById("f").submit();
         }
      }
      //��������
      function pubBatch(){
         if(confirm("ȷ��Ҫ����������")){
             document.getElementById("pageNo").value="1";
	         document.getElementById("f").action="ArticleServlet?m=pubBatch";
	         document.getElementById("f").submit();
         }
      }
      //����
      function pub(url){
         if(confirm("ȷ��Ҫ������")){
	         document.getElementById("f").action=url; 
	         document.getElementById("f").submit();
         }
      }
     
      //�༭ʱ���´���
      function openWin(url){
         window.open(url,'newwindow','height=600,width=800,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
      }
      //�ύ������Ϣ����ʾ��һҳ���
      function form_submit(){
         document.getElementById("pageNo").value="1"; //ҳ������Ϊ1
         document.getElementById("f").submit();
      }
      
</script>
     
</head>
  
<body>
<form action="ArticleServlet?m=list" method="post" id="f">
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
                       <td width="94%" valign="bottom"><span class="STYLE1"> ��վ������Ϣ�б�</span></td>
                     </tr>
                   </table>
                 </td>
                 <td><div align="right"><span class="STYLE1">
                      &nbsp;&nbsp;<img src="images/add.gif" width="10" height="10" /> <a href="ArticleServlet?m=addInput" target="rightFrame">���</a>   
                      &nbsp;&nbsp;<img src="images/edit.gif" width="10" height="10" /> <a href="javascript:pubBatch()">����</a>
                      &nbsp; <img src="images/del.gif" width="10" height="10" /> <a href="javascript:delBatch()">ɾ��</a>    &nbsp;&nbsp;   &nbsp;
                      </span><span class="STYLE1"> &nbsp;</span>
                     </div>
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
         
          <b>�ؼ��֣�</b>
          <input type="text" name="titleKey" value="${titlekey==null?'':titlekey}"/>
          <input type="hidden" name="pageNo" id="pageNo" value="${pageNo==null?'1':pageNo}" />
          <input type="button" value="����" onclick="form_submit()"/>
     </td>
   </tr>
   <tr>
      <td>
       
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
          <tr>
             <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
               <div align="center">
                <input type="checkbox"  id="checkAll" onclick="checkedAll();" />
               </div>
             </td>
             <td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">���±���</span></div></td>
             <td width="50" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">������Դ</span></div></td>
	         <td width="50" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">�����</span></div></td>
	         <td width="50" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">������</span></div></td>
	         <td width="70" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">����ʱ��</span></div></td>
	         <td width="70" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">����ʱ��</span></div></td>
	         <td width="70" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">����ʱ��</span></div></td>
	         <td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">��������</span></div></td>
          </tr>
		  <c:if test="${not empty articles}">
		  <c:forEach items="${articles}" var="a">
	      <tr>
	         <td height="20" bgcolor="#FFFFFF">
	            <div align="center">
	               <input type="checkbox" name="checkItem" value="${a.id}" id="checkItems${a.id}" />
	            </div>
	         </td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><a href="javascript:openWin('ArticleServlet?m=modifyInput&id=${a.id}')" title="����鿴�ͱ༭����">${a.title}</a></div></td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${a.source}</div></td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${a.clickScore}</div></td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${a.msgCount}</div></td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${a.createTime}</div></td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19">
	         	<div align="center">
					<c:choose>
						<c:when test="${not empty a.updateTime}">${a.updateTime}</c:when>
						<c:otherwise>δ����</c:otherwise>
					</c:choose>	         
	         
	         	</div>
	         </td>
	         <td height="20" bgcolor="#FFFFFF" class="STYLE19">
	            <div align="center">
	         		<c:choose>
						<c:when test="${not empty a.publishTime}">${a.publishTime}</c:when>
						<c:otherwise>δ����</c:otherwise>
			 		</c:choose>
			 	</div>
	         </td>	
	         <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">
	            <c:choose>
		            <c:when test="${not empty a.publishTime}">
		            	�ѷ���|
		            </c:when>
		            <c:otherwise>
		            	<a href="javascript:pub('ArticleServlet?m=pub&id=${a.id}')" title="�����������">����</a> |
		            </c:otherwise>
	            </c:choose>
	            <a href="javascript:del('ArticleServlet?m=del&id=${a.id}')" title="���ɾ������">ɾ��</a> |
	            <a href="javascript:openWin('ArticleServlet?m=modifyInput&id=${a.id}')" title="����༭����">�༭</a>
	            </div>
	         </td>
	     </tr>
	     </c:forEach>
	     </c:if>
	     <c:if test="${empty articles}">
	       <tr>
	     	<td colspan="9" height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">û�����¿�����ʾ</div></td>
	       </tr>     
	     </c:if>
       </table>
     </td>
   </tr>
   <tr>
     <td height="30">
       <jsp:include page="../common/pager.jsp">
       	 <jsp:param value="${pageModel}" name="pageModel"/>
       </jsp:include>
     </td>
   </tr>

  </table>
</form> 
</body>
</html>
