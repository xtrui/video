package com.Video.action;


import java.io.*;
import java.util.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.Video.Dao.VideoInfosDao;
import com.Video.entity.VideoInfo;


public class Upfile extends HttpServlet {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String filePath="D:\\Workspaces\\.metadata\\.me_tcat\\webapps\\Video\\video\\";
   private int maxFileSize =5 * 1024 * 1024 * 1024;
   private int maxMemSize = 100 * 1024;
   private File file ;


   public void doPost(HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
	   
	   request.setCharacterEncoding("utf-8");
		response.setContentType("text/ html;charset=utf-8");
	   VideoInfosDao dao = new VideoInfosDao();
	   int vnum = dao.findVideoC();
	   String name = ""+vnum;
	   
	   //HttpSession session = request.getSession(false);
	   //if(session.getAttribute("un")=="admin"){
	   
	   
      ServletFileUpload.isMultipartContent(request);
		      response.setContentType("text/html");
		      java.io.PrintWriter out = response.getWriter( );
		      
		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // 文件大小的最大值将被存储在内存中
		      factory.setSizeThreshold(maxMemSize);
		      // Location to save data that is larger than maxMemSize.
		      factory.setRepository(new File("c:\\temp"));
		
		      // 创建一个新的文件上传处理程序
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      // 允许上传的文件大小的最大值
		      upload.setSizeMax( maxFileSize );
		
		      try{ 
		      // 解析请求，获取文件项
		      List<?> fileItems = upload.parseRequest(request);
		   
		      // 处理上传的文件项
		      Iterator<?> i = fileItems.iterator();
		
		  
		      while ( i.hasNext () ) 
		      {
		         FileItem fi = (FileItem)i.next();
		         if ( !fi.isFormField () )   
		         {
		            // 获取上传文件的参数
		            String fieldName = fi.getFieldName();
		            String fileName = name+".mp4";//fi.getName()
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // 写入文件
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( fileName.substring(fileName.lastIndexOf("\\"))) ;//fileName.lastIndexOf("\\")
		               
		            }else{
		               file = new File( filePath + 
		            		   fileName.substring(fileName.lastIndexOf("\\")+1)) ;//fileName.lastIndexOf("\\")+1
		               
		            }
		            fi.write( file ) ;
		            
		            
		            out.println("Upload OK <br>");
		         }
		      }
		      
		      out.println("</body>");
		      out.println("</html>");
		   }catch(Exception ex) {
		       System.out.println(ex);
		   }
		      
		      
	   }
      
      
   // }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        
   } 
}
