package com.Practical;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/TryCode")
public class TryCode extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		res.getWriter().println("<html><body><h1>User Details:</h1><br><p>Name: "+ req.getParameter("name") + "</p><br><p>E-mail: "+ req.getParameter("email")+ "</p><br><p>Phone: "+ req.getParameter("phone")+"</p></body></html>");
	}

}
