package com.set1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SqServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int k = (int) req.getAttribute("k");  //Request Dispatcher
//		int k = Integer.parseInt(req.getParameter("k"));   //Send-redirect URL re-writing..
		
//		HttpSession session = req.getSession();  //Session
//		int k = (int) session.getAttribute("k");
		
		int k=0;
		Cookie[] cookies = req.getCookies();  //Cookie
		for(Cookie c : cookies)
		{
			if(c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		
		k=k*k;
		
		PrintWriter out=res.getWriter();
		out.println(k);
		
		}
}
