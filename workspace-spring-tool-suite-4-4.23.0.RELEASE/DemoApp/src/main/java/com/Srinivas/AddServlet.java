package com.Srinivas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/add")
public class AddServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		ServletContext ctx = getServletContext();
		String str = ctx.getInitParameter("Phone");
		PrintWriter out = res.getWriter();
		out.print(str+"\n");
		
		ServletConfig cg = getServletConfig();
		str = cg.getInitParameter("Srinivas");
		out.print(str);

		
//		int i = Integer.parseInt(req.getParameter("n1"));
//		int j = Integer.parseInt(req.getParameter("n2"));
//		
//		int k = i + j;
//		
////		k=k*k;
//		
//		Cookie cookie = new Cookie("k", k +"");
//		res.addCookie(cookie);
//		
////		HttpSession session = req.getSession(); //Session management..
////		session.setAttribute("k", k);
//		
//		res.sendRedirect("sq?k="+k); //URL rewriting
//		req.setAttribute("k", k);
//		RequestDispatcher rd = req.getRequestDispatcher("sq"); //Url Dispatcher
		
//		
//		rd.forward(req, res);
		
	}
}