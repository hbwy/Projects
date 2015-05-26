<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<script type="text/javascript">
	  //��������ҳ
      function go(pageNo){
         document.getElementById("pageNo").value=pageNo; //�����ύ��ҳ��
         document.getElementById("f").submit();
      }
      //�ύ��ҳ��С����ʾ��һҳ���
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
                                                      ���� <strong>${pageModel.rowCount}</strong> ����¼��
  				  <c:choose>
  				  	<c:when test="${pageModel.rowCount == 0}">��ǰ�� <strong>0</strong> ҳ</c:when>
  				  	<c:otherwise>��ǰ�� <strong>${pageModel.pageNo}</strong> ҳ��</c:otherwise>
  				  </c:choose>
                                                      �� <strong>${pageModel.totalPages}</strong> ҳ
               </span>
              </div>
           </td>
           <td width="67%" align=right vAlign="center" noWrap>
           	      <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != 1}"> <a href="javascript:go(1)">��ҳ</a></c:when>
  				  	<c:otherwise>��ҳ</c:otherwise>
  				  </c:choose>
  				  
  				  <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != 1}"> <a href="javascript:go(${pageModel.pageNo-1 })">��ҳ</a></c:when>
  				  	<c:otherwise>��ҳ</c:otherwise>
  				  </c:choose>

				  <c:forEach  begin="1" end="${pageModel.totalPages}" step="1" var="i">
				  	<c:if test="${i>=pageModel.pageNo-3 && i<=pageModel.pageNo+3}">
				  		<c:if test="${pageModel.pageNo == i}"><a href="javascript:go(${i})"><font color="RED">${i}</font></a></c:if>
				  		<c:if test="${pageModel.pageNo != i}"> <a href="javascript:go(${i})">${i}</a></c:if>
				  	</c:if>	
				  </c:forEach>
				
				  <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != pageModel.totalPages}"> <a href="javascript:go(${pageModel.pageNo+1})">��ҳ</a></c:when>
  				  	<c:otherwise>��ҳ</c:otherwise>
  				  </c:choose>
				
				  <c:choose>
  				  	<c:when test="${pageModel.totalPages>1 && pageModel.pageNo != pageModel.totalPages}"> <a href="javascript:go(${pageModel.totalPages})">βҳ</a></c:when>
  				  	<c:otherwise>βҳ</c:otherwise>
  				  </c:choose>
				
				
				<select name="pageSize" onchange="selectPagesize(this)" >
				  <c:forEach begin="5" step="5" end="50" var="i">
				  	<option value="${i }" <c:if test="${pageModel.pageSize == i}">selected</c:if> > ${i}</option>
				  </c:forEach>
				</select>

           </td>
         </tr>
       </table>
