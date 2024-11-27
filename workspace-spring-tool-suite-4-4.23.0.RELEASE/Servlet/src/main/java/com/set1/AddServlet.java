package com.set1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("n1"));
		int j = Integer.parseInt(req.getParameter("n2"));
		
		int k = i+j;
//		PrintWriter out= res.getWriter(); //Normal
//		out.println(k);
		
//		req.setAttribute("k", k);
//		RequestDispatcher rd = req.getRequestDispatcher("sq"); //Request Dispatcher
//		rd.forward(req, res);
		
//		res.sendRedirect("sq?k="+k); //send-redirect URL-rewritting...
		
//		HttpSession session = req.getSession();  //Session
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");
		
		Cookie cookie=new Cookie("k", k+""); //cookie 
		res.addCookie(cookie);
		res.sendRedirect("sq");		
	}
}
