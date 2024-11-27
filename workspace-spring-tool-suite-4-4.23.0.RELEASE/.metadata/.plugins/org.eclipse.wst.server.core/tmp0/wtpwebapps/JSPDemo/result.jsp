<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result Page</title>
</head>
<body>
    <h1>Result</h1>
    <%
        // Retrieving the username attribute from the request
        String username = (String) request.getAttribute("username");
        out.println("<h2>Hello, " + username + "!</h2>");
    %>
</body>
</html>
