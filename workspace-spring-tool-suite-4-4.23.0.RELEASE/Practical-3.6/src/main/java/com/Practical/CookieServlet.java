package com.Practical;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie c = new Cookie("username", "me_lier");
		c.setMaxAge(24*60*60);
		res.addCookie(c);
		res.setContentType("text/html");
		res.getWriter().println("<html><head><title>Cookie Example</title></head><body><h1>Cookie Has been Set!</h1></body></html>");
	}

}
