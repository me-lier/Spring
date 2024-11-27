package com.Practical;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/HttpSessionEx1")
public class HttpSessionEx1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("username", name);
		session.setAttribute("password", pass);
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><a href='HttpSessionEx1_1'>Click to View Session Info</a></body</html>");
		out.close();
		
	}
}
