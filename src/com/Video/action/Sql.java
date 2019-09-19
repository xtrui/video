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

      // JDBC 驱动器名称和数据库的 URL
      final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost:3306/video?useUnicode=true&characterEncoding=utf8";

      //  数据库的用户名与密码，需要根据自己的设置
      final String USER = "root";
      final String PASS = "123456";

      // 设置响应内容类型
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      try{
         // 注册 JDBC 驱动器
         Class.forName("com.mysql.jdbc.Driver");

         // 打开一个连接
         Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

         // 执行 SQL 查询
         Statement stmt = conn.createStatement();
         
         String sql;
         sql = "SELECT * FROM V";
         ResultSet rs = stmt.executeQuery(sql);
         	out.println(sql);
         // 展开结果集数据库
         while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("VID");
            
            String first = rs.getString("Jj");
            String last = rs.getString("Title");

            // 输出数据
            out.println("ID: " + id + "<br>");
            
            out.println(", First: " + first + "<br>");
            out.println(", Last: " + last + "<br>");
         }
         out.println("</body></html>");

         // 完成后关闭
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         // 处理 JDBC 错误
         se.printStackTrace();
      }catch(Exception e){
         // 处理 Class.forName 错误
         e.printStackTrace();
      }finally{
         
      }
   }
} 
