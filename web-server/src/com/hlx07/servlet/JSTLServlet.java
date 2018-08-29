package com.hlx07.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlx07.domain.User;

/**
 * Servlet implementation class JSTLServlet
 */
@WebServlet("/JSTLServlet")
public class JSTLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSTLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<User> users=new ArrayList<User>();
		for(int i=0;i<4;i++){
			User u=new User("zxj"+i, "111"+i);
			users.add(u);
			u=null;
		}
		boolean flag=false;
		request.setAttribute("flag", flag);
		request.setAttribute("list", users);
		
		//通过request的getRequestDispatcher方法进行页面的跳转
		request.getRequestDispatcher("jstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
