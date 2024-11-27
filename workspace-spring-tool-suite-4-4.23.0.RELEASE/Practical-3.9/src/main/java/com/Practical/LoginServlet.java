package com.Practical;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Predefined username and password for simplicity
    private final String USERNAME = "admin";
    private final String PASSWORD = "password123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Set content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if username and password match predefined values
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome, " + username + "!</p>");
        } else {
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password.</p>");
        }

        // Close the output writer
        out.close();
    }
}