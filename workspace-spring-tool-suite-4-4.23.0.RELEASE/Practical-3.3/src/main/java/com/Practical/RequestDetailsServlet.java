package com.Practical;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestDetailsServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body><h1>Request Details</h1><br><p>Request Method: " + req.getMethod() + "</p><br><p>Request URI: " + req.getRequestURI() + "</p><br><p>Request Protocol: "+ req.getProtocol() + "</p><br><p>Request QueryString: " + req.getQueryString() + "</p><br><p>Request Remote Address: " + req.getRemoteAddr() + "</p><br><p>Request Remote Host: " + req.getRemoteHost() + "</p></body></html>");
	}

}
