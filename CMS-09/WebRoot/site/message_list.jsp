<%@ page import="cms.model.*,java.util.*,cms.utils.*" pageEncoding="GB18030"%>
<% List<Message> messages = (List<Message>)request.getAttribute("messages");
   PageModel pm = (PageModel)request.getAttribute("pageModel");
 %>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

<div align="left">	
		<hr style="border:1px dashed gray; height:1px;width:400px" align="left">
	<% for(int i=0;i<messages.size();i++){ 
		    Message m = messages.get(i);
	%>      
	         <div>
			     留言内容：    <%=m.getContent() %>
			 <br>
			     留言者：<%=m.getPublisher() %>
			     时间:<%=DateConverter.format(m.getPublishTime(), "yyyy-MM-dd hh:mm:ss") %>
			</div>
			<hr style="border:1px dashed gray; height:1px;width:400px" align="left">
	<%} %>
    
    <%for(int i=1;i<=pm.getTotalPages();i++){ %>
        <a href="article.jsp?articleId=<%=request.getParameter("articleId") %>&pageNo=<%=i %>">[<%=i %>]</a>
    <%} %>
	<br/>
	<form action="site/MessageServlet?m=add" method="post">
	    <input type="hidden" name="articleId" value="<%=request.getParameter("articleId") %>">
	    <textarea rows="5" cols="50" name="content"></textarea>
	         <script type="text/javascript">
	             CKEDITOR.replace('content',{
	             	width:600,
	             	toolbar:"Full",
	             	toolbar_Full:[
	             	    ['Bold','Italic','Underline','Strike'],
	             	    ['Link','Unlink','Anchor'],
	             	    ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	             	    '/',
	             	    ['Styles','Format','Font','Fontsize'],
	             	    ['TextColor','BGColor']
	             	]
	             });
	             
	         </script>
	         <div>
	         <input name="submit" type="submit" class="buttom" value="发表">
	         </div>
	</form>

</div>
 