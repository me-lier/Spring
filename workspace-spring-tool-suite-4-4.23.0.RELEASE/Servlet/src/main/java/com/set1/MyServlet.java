package com.set1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		ServletContext ctx = getServletContext();
		String str = ctx.getInitParameter("Name");
		
		out.println("Hii, " + str);
		
		out.println("You Have this Phone :-> " + ctx.getInitParameter("Phone"));
		
		ServletConfig cg = getServletConfig();
		out.println("Your Dad Name is :-> " + cg.getInitParameter("Dad"));
	}
}
