package com.Video.util;

import java.sql.*;
public class Sqlcn {
	
	public  Connection conn(){
		final String DB_URL="jdbc:mysql://localhost:3306/video?useUnicode=true&characterEncoding=utf8";

	      //  ���ݿ���û��������룬��Ҫ�����Լ�������
	      final String USER = "root";
	      final String PASS = "123456";

	      // ������Ӧ��������
	      
	      
	      try{
	         // ע�� JDBC ������
	         Class.forName("com.mysql.jdbc.Driver");

	         // ��һ������
	         Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // ִ�� SQL ��ѯ
	         
	         
	         
	         
	        
	         return conn;
	      }catch(SQLException se){
	         // ���� JDBC ����
	         se.printStackTrace();
	      }catch(Exception e){
	         // ���� Class.forName ����
	         e.printStackTrace();
	      }finally{
	         
	      }
	      return null;
	}
	
	
	
}
