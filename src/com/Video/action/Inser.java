package com.Video.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Video.Dao.VideoInfosDao;
import com.Video.entity.VideoInfo;

public class Inser extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/ html;charset=utf-8");
	   VideoInfosDao dao = new VideoInfosDao();
	   int vnum = dao.findVideoC()+1;
	   String name = ""+vnum;

		VideoInfo video2= new VideoInfo();
        video2.Title = request.getParameter("Title");
        video2.Jj = request.getParameter("Jj");
        video2.Url = "video/"+name+ ".mp4";
        video2.Cat = request.getParameter("Cat");
         int a=dao.insert(video2);
        PrintWriter out = response.getWriter();
        out.println(video2.Title+"---"+video2.Jj+"---"+video2.Url+"---"+video2.Cat);
        out.println(a);
	}

}
