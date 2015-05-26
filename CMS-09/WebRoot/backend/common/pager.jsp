<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
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
     
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td width="33%">
              <div align="left">
               <span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;
                                                      共有 <strong>${pageModel.rowCount}</strong> 条记录，
  				  <c:choose>
  				  	<c:when test="${pageModel.rowCount == 0}">当前第 <strong>0</strong> 页</c:when>
  				  	<c:otherwise>当前第 <strong>${pageModel.pageNo}</strong> 页，</c:otherwise>
  				  </c:choose>
                                                      共 <strong>${pageModel.totalPages}</strong> 页
               </span>
              </div>
           </td>
           <td width="67%" align=right vAlign="center" noWrap>
           	      <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != 1}"> <a href="javascript:go(1)">首页</a></c:when>
  				  	<c:otherwise>首页</c:otherwise>
  				  </c:choose>
  				  
  				  <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != 1}"> <a href="javascript:go(${pageModel.pageNo-1 })">上页</a></c:when>
  				  	<c:otherwise>上页</c:otherwise>
  				  </c:choose>

				  <c:forEach  begin="1" end="${pageModel.totalPages}" step="1" var="i">
				  	<c:if test="${i>=pageModel.pageNo-3 && i<=pageModel.pageNo+3}">
				  		<c:if test="${pageModel.pageNo == i}"><a href="javascript:go(${i})"><font color="RED">${i}</font></a></c:if>
				  		<c:if test="${pageModel.pageNo != i}"> <a href="javascript:go(${i})">${i}</a></c:if>
				  	</c:if>	
				  </c:forEach>
				
				  <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != pageModel.totalPages}"> <a href="javascript:go(${pageModel.pageNo+1})">下页</a></c:when>
  				  	<c:otherwise>下页</c:otherwise>
  				  </c:choose>
				
				  <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != pageModel.totalPages}"> <a href="javascript:go(${pageModel.totalPages})">尾页</a></c:when>
  				  	<c:otherwise>尾页</c:otherwise>
  				  </c:choose>
				
				
				<select name="pageSize" onchange="selectPagesize(this)" >
				  <c:forEach begin="5" step="5" end="50" var="i">
				  	<option value="${i }" <c:if test="${pageModel.pageSize == i}">selected</c:if> > ${i}</option>
				  </c:forEach>
				</select>

           </td>
         </tr>
       </table>
