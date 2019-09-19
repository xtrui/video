<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>视频发布</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h3>文件上传：</h3>
        
        <form action="Inser"  method="post"   >
            视频标题：<input type="text" name="Title" id="Title">
            <br /><br /><br /><br />
            
            视频简介：<textarea name="Jj" id="Jj" maxlength="200"  cols="50" rows="10"></textarea>
            <br /><br />
            
            类别：<select name="Cat" id="Cat">
                    <option value ="电影">电影</option>
                    <option value ="动漫">动漫</option>
                    <option value="综艺">综艺</option>
                    <option value="体育">体育</option>
                    <option value="电视剧">电视剧</option>
                  </select>
            <br /><br />
            
        </form>

        <form action="Upfile" method="post"  name="form1"    enctype="multipart/form-data" >
            请选择要上传的视频文件，（仅支持mp4）：<br />
            <br />
            <input type="file" name="file" size="50" />
            <br /><br />
            

        </form>
        <input type="button" value="提交" onclick="sub();" />
        <input type="reset" value="重置" >
    
</body>
</html>
<script>
    function sub(){
        var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
        form1.submit();
    }
  }
xmlhttp.open("POST","http://laptop-tianrui:8080/Video/Inser",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("Title="+Title.value+"&Jj="+Jj.value+"&Cat="+Cat.value);
}
</script>
