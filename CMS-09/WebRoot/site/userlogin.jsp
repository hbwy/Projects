<%@page import="cms.model.*,java.util.*" pageEncoding="GB18030"%>
<%if(request.getSession().getAttribute("LOGIN_MEMBER")==null) {%>
<div class="right">
		<div class="right_topic_1">
			�û�����
		</div>
		<div class="right_topic_2">
		</div>
		<div class="right_topic_3">
			<form id="login" action="site/MemberLoginServlet">
				<input type="hidden" name="m" value="login">
				�ǳƣ�<input type="text" name="nickname" value=""/><br>
				���룺<input type="password" name="password" value=""/><br>
				<input type="submit" value="��¼" />
				<input type="button" value="ע��" onclick="javascript:window.location.href='member/reg_input.jsp'"/>
			</form>
		</div>
</div>
<% }else{%>
  <div class="right">
		<div class="right_topic_1">
			�û�����
		</div>
		<div class="right_topic_2">
		</div>
		<div class="right_topic_3">
			<form action="site/MemberLoginServlet">
				<input type="hidden" name="m" value="loginOut">
				<% Member m = (Member)request.getSession().getAttribute("LOGIN_MEMBER");%>
				�û�<%=m.getNickname()%>�ѵ�¼<br>
				<input type="button"  value="��������" onclick="javascript:window.location.href='site/MemberServlet?m=get&id=<%=m.getId()%>'"/>
				<input type="submit" value="�˳�">
			</form>
		</div>
</div>
<%} %>
