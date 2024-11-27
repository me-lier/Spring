package com.Srinivas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Cookie cookie[] = req.getCookies();
		int k=0;
		
		for(Cookie c:cookie) {
			if(c.getName().equals("k")) {
				k=Integer.parseInt(c.getValue());
			}
		}
//		HttpSession session = req.getSession();
//		
//		int k =(int) session.getAttribute("k");
		
//		int k = Integer.parseInt(req.getParameter("k"));
		k=k*k;
		PrintWriter out = res.getWriter();
		out.println(k);
		
	}
}
