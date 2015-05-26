<%@ page language="java" import="java.util.*,cms.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
  <script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
  </head>
  
  <body>
     <div id="formwrapper">
         <h3>添加文章</h3>
         <hr>
         <form action="ArticleServlet?m=add" method="post" enctype="multipart/form-data">
         <fieldset>
            <legend>文章基本信息</legend>
            <br/>
            <div>
                <label for="title">文章标题</label>
                <input type="text" name="title" id="title" value="" size="60" maxlength="20" />
                *(最多20个字符) <br/>
            </div>
            <br/>
            <div>
                <label for="source">文章来源</label>
                <input type="text" name="source" id="source" value="" size="60" maxlength="50" />
                *(最多50个字符) <br/>
            </div>
            <br/>
            <div>
                <label for="author">文章作者</label>
                <input type="text" name="author" id="author" value="" size="60" maxlength="20" />
                *(最多20个字符) <br/>
            </div>
            <br/>
            <div>
                <label for="channelId">所属频道</label>
                <select name="channel">
                <%List<Channel> channels = (List<Channel>)(request.getAttribute("channels"));
                  for (Channel c : channels){
                 %> 
                       <option value="<%=c.getId()%>"><%=c.getName()%> </option>
                 <%} %> 
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label for="keyword">关键字</label>
                <input type="text" name="keyword" id="keyword" value="" size="30" maxlength="30"/>
                *(关键字用逗号隔开)
            </div>
            
            <br/>
            <div>
                <label for="recommend">设置属性</label>
                <input type="checkbox" name="recommend" id="recommend" value="true" />推荐
                <input type="checkbox" name="headerLine" id="headerLine" value="true" />头条
            </div>
             <br/>
            <div>
                <label for="content">文章内容</label>
                <textarea rows="20" cols="100" name="content">单击此处添加文章</textarea>
                <script type="text/javascript">
	             CKEDITOR.replace('content');
	         	</script>
            </div>
             <br/>
             <div>
				<label for="attachs">选择附件</label>
				<input type="file" name="attachs" id="attachs">
			</div>
			<br/>	
            <div class="enter">  
                <input name="submit" type="submit" class="buttom" value="提交">
                <input name="reset" type="reset" class="buttom" value="重置">
            </div>
         </fieldset> 
         </form>
        
     </div>
  </body>
</html>
