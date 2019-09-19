<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.Video.entity.VideoInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>登录注册页面</title>
</head>
<body>
      <form action="Login" method="post" >
        <table border="1px" align="center" cellpadding="2px" width="300px">
             <tr>
             	<td>用户名:</td>
             	<td><input type="text" name="username" id="username" placeholder="用户名（2-6字母）"></td>
             </tr>
             <tr>
             	<td>密 &nbsp;&nbsp;码:</td>
             <td><input type="password" name="password" id="password" placeholder="密码（6位数字和字母组合）"></td>
             </tr>
             <tr> 
                <td colspan="2" align="center"><input type="submit" value="登录" onclick="return aclick()">
                  <input type="reset">
                </td>
             </tr>
        </table>
        <hr>
         
       </form>
       <h3>
       ${zt}
       </h3>
	
	 <script >//type="text/javascript" src="login.js"
	document.getElementById("username").onblur=function(){
      var username=document.getElementById("username").value;
      var reg = /^[a-zA-Z]{2,6}$/;
      
      if(!reg.test(username)){
        
        alert("请输入2-6位的字母！");
      }
}
document.getElementById("password1").onblur=function(){
    var password1=document.getElementById("password1").value;
    var reg=/^[a-zA-Z0-9]{6}$/;
    if(!reg.test(password1)){
        alert("请输入6位的字母和数字组合");
    }
}
document.getElementById("password2").onblur=function(){
    var password1=document.getElementById("password1").value;
    var password2=document.getElementById("password2").value;
    if (password1!=password2) {
        alert("两次密码输入不一致！");
    }
}
document.getElementById("submit1").onclick=function(){
     var username=document.getElementById("username").value;
      if(username==""||username==null){
            alert("用户名不能为空");
      }
      var password1=document.getElementById("password1").value;
      if(password1==""||password1==null){
            alert("密码不能为空！");
      }
     var password2=document.getElementById("password2").value;
     if (password1!=password2) {
        alert("两次密码输入不一致！");
    }

}
     </script>
</body>
</html>