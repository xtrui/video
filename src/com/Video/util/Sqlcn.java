package com.Video.util;

import java.sql.*;
public class Sqlcn {
	
	public  Connection conn(){
		final String DB_URL="jdbc:mysql://localhost:3306/video?useUnicode=true&characterEncoding=utf8";

	      //  数据库的用户名与密码，需要根据自己的设置
	      final String USER = "root";
	      final String PASS = "123456";

	      // 设置响应内容类型
	      
	      
	      try{
	         // 注册 JDBC 驱动器
	         Class.forName("com.mysql.jdbc.Driver");

	         // 打开一个连接
	         Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // 执行 SQL 查询
	         
	         
	         
	         
	        
	         return conn;
	      }catch(SQLException se){
	         // 处理 JDBC 错误
	         se.printStackTrace();
	      }catch(Exception e){
	         // 处理 Class.forName 错误
	         e.printStackTrace();
	      }finally{
	         
	      }
	      return null;
	}
	
	
	
}
