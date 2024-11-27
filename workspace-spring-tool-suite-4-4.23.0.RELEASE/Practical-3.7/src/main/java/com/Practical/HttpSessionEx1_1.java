package com.Practical;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/HttpSessionEx1_1")
public class HttpSessionEx1_1 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.write("<html><body>");
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("username") == null) {
			res.sendRedirect("HttpSessionEx1");
			return;
		}
		String myName = (String) session.getAttribute("username");
		String myPass = (String) session.getAttribute("password");
		out.write("<p>Username: " + myName + "</p><br><p>Password: " + myPass + "</p><br><p>Creation Time of Session(ms): " + session.getCreationTime() + "</p><br><p>Creation Date: " + new Date(session.getCreationTime()) + "</p><br><p>Last Accesed(ms): " + session.getLastAccessedTime() + "</p><br><p>Last Accessed Date: " + new Date(session.getLastAccessedTime()) + "</p></body></html>");
		out.close();
	}
}

