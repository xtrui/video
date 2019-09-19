package com.Video.action;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
 
public class Sql extends HttpServlet{
    
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/ html;charset=utf-8");

      // JDBC ���������ƺ����ݿ�� URL
      final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost:3306/video?useUnicode=true&characterEncoding=utf8";

      //  ���ݿ���û��������룬��Ҫ�����Լ�������
      final String USER = "root";
      final String PASS = "123456";

      // ������Ӧ��������
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      try{
         // ע�� JDBC ������
         Class.forName("com.mysql.jdbc.Driver");

         // ��һ������
         Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

         // ִ�� SQL ��ѯ
         Statement stmt = conn.createStatement();
         
         String sql;
         sql = "SELECT * FROM V";
         ResultSet rs = stmt.executeQuery(sql);
         	out.println(sql);
         // չ����������ݿ�
         while(rs.next()){
            // ͨ���ֶμ���
            int id  = rs.getInt("VID");
            
            String first = rs.getString("Jj");
            String last = rs.getString("Title");

            // �������
            out.println("ID: " + id + "<br>");
            
            out.println(", First: " + first + "<br>");
            out.println(", Last: " + last + "<br>");
         }
         out.println("</body></html>");

         // ��ɺ�ر�
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         // ���� JDBC ����
         se.printStackTrace();
      }catch(Exception e){
         // ���� Class.forName ����
         e.printStackTrace();
      }finally{
         
      }
   }
} 
