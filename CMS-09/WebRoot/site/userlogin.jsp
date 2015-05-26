<%@page import="cms.model.*,java.util.*" pageEncoding="GB18030"%>
<%if(request.getSession().getAttribute("LOGIN_MEMBER")==null) {%>
<div class="right">
		<div class="right_topic_1">
			用户操作
		</div>
		<div class="right_topic_2">
		</div>
		<div class="right_topic_3">
			<form id="login" action="site/MemberLoginServlet">
				<input type="hidden" name="m" value="login">
				昵称：<input type="text" name="nickname" value=""/><br>
				密码：<input type="password" name="password" value=""/><br>
				<input type="submit" value="登录" />
				<input type="button" value="注册" onclick="javascript:window.location.href='member/reg_input.jsp'"/>
			</form>
		</div>
</div>
<% }else{%>
  <div class="right">
		<div class="right_topic_1">
			用户操作
		</div>
		<div class="right_topic_2">
		</div>
		<div class="right_topic_3">
			<form action="site/MemberLoginServlet">
				<input type="hidden" name="m" value="loginOut">
				<% Member m = (Member)request.getSession().getAttribute("LOGIN_MEMBER");%>
				用户<%=m.getNickname()%>已登录<br>
				<input type="button"  value="个人中心" onclick="javascript:window.location.href='site/MemberServlet?m=get&id=<%=m.getId()%>'"/>
				<input type="submit" value="退出">
			</form>
		</div>
</div>
<%} %>
