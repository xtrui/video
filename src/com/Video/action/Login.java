package com.Video.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Video.Dao.UserInfoDao;

public class Login extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/ html;charset=utf-8");
		UserInfoDao dao = new UserInfoDao();
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		int f = dao.findUser(u, p);
		
		if(f!=0){
			request.setAttribute("zt","登录成功");
			request.getSession().setAttribute("UID", f);
			request.getRequestDispatcher("/Getvideos").forward(request, response);
		}
		else 
		{
			request.setAttribute("zt","账户不存在或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
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

		doGet(request, response);
	}

}
