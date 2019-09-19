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
	<meta charset="UTF-8">
	<title>register</title>
</head>
<body>
	<form action="Register" method="post" >
	 <table border="1px" align="center" cellpadding="2px" width="300px">
             <tr>
             	<td>用户名:</td>
             	<td><input type="text" name="username" id="username" placeholder="2-6位字母"></td>
             </tr>
             <tr>
             	<td>密 &nbsp;&nbsp;码:</td>
             <td><input type="password" name="password1" id="password1" placeholder="6位数字和字母组合"></td>
             </tr>
             <tr>
             	<td>确认密码：</td>
             	<td><input type="password" name="password2" id="password2" placeholder="6位数字和字母组合"></td>
             </tr>
             <tr> 
                <td colspan="2" align="center"><input type="submit" value="提交" id="submit1">
                  <input type="reset">
                </td>
             </tr>
        </table><hr>
        </form>
        <h3>
        ${zt }
        </h3>
</body>
<script type="text/javascript" src="register.js"></script>
</html>