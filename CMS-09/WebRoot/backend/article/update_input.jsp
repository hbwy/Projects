<%@ page language="java" import="java.util.*,cms.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
    <title>文章管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <style type="text/css">
	<!--  body {
		margin-left: 3px;
		margin-top: 0px;
		margin-right: 3px;
		margin-bottom: 0px;
		font-size: 12;
		}
	-->
  </style>

  </head>
  
  <body>
     <% Article a = (Article)(request.getAttribute("article")); %>
     <div id="formwrapper">
         <h4>编辑文章</h4> 
         <form action="ArticleServlet?m=modify" method="post">
         <input type="hidden" name="id" value="<%=a.getId() %>" />
         <fieldset>
            <legend>文章基本信息</legend>
  
            <div>
                <label for="title">文章标题</label>
                <input type="text" name="title" id="title" value="<%=a.getTitle() %>" size="60" maxlength="20" />
                *(最多20个字符) <br/>
            </div>
            <div>
                <label for="source">文章来源</label>
                <input type="text" name="source" id="source" value="<%=a.getSource() %>" size="60" maxlength="50" />
                *(最多50个字符) <br/>
            </div>
            <div>
                <label for="author">文章作者</label>
                <input type="text" name="author" id="author" value="<%=a.getAuthor() %>" size="60" maxlength="20" />
                *(最多20个字符) <br/>
            </div>
            <br>
            <div>
                <label for="channelId">所属频道</label>
                <select name="channel">
                <option value=""> </option>
                <%List<Channel> channels = (List<Channel>)(request.getAttribute("channels"));
                  for (Channel c : channels){
                 %> 
                       <option value="<%=c.getId()%>" <%=(c.getId().equals(a.getChannel().getId()))?"selected":"" %> ><%=c.getName()%> </option>
                 <%} %> 
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label for="keyword">关键字</label>
                <input type="text" name="keyword" id="keyword" value="<%=a.getKeyword() %>" size="30" maxlength="30"/>
                *(关键字用逗号隔开)
            </div>
            <div>
                <label for="">设置属性</label>
                <input type="checkbox" name="recommend" id="recommend" value="1" <%=a.isRecommend()?"checked":"" %> />推荐
                <input type="checkbox" name="headerLine" id="headerLine" value="1" <%=a.isHeaderLine()?"checked":"" %>/>头条
            </div>
            <br>
            <div>
                <label for="content">文章内容</label>
                <textarea rows="20" cols="100" name="content"><%=a.getContent() %></textarea>
                 <script type="text/javascript">
                   CKEDITOR.replace('content');
                </script>
            </div>
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="修改">
                <input name="reset" type="reset" class="buttom" value="重置">
            </div>
         </fieldset> 
         </form>
        
     </div>
  </body>
</html>
