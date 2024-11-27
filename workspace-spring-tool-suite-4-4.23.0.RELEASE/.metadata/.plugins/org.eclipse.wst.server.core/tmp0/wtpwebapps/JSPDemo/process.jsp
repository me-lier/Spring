<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Process Input</title>
</head>
<body>
    <h1>Processing Input</h1>
    <%
        // Retrieving the username from the form
        String username = request.getParameter("username");

        // Forwarding to the result.jsp page
        request.setAttribute("username", username);
        String nextPage = "result.jsp"; // Page to forward to
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    %>
</body>
</html>
 s