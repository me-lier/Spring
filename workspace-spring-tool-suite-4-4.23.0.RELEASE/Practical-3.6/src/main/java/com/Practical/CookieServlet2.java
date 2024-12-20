package com.Practical;

import java.io.IOException;
import java.net.CookieStore;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		Cookie[] cookies = req.getCookies();
		res.getWriter().println("<html><body><h1>Cookies:</h1>");
		if(cookies!=null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				res.getWriter().println("<p>Cookie Name: "+cookie.getName() + "<br> Cookie Value: "+ cookie.getValue() + "</p>");
			}
		} else {
			res.getWriter().println("<p>No Cookies Found</p>");
		}
		res.getWriter().println("</body></html>");
	}

}
