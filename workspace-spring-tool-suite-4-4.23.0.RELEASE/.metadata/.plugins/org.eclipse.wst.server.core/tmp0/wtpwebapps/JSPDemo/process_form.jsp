<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Process Input</title>
</head>
<body>
    <h1>Processing Input</h1>
    <%
        // Using the 'request' implicit object to retrieve the 'name' parameter
        String name = request.getParameter("name");
        
        if (name != null) {
            out.println("<h2>Hello, " + name + "!</h2>");
        } else {
            out.println("<h2>No name was provided.</h2>");
        }
    %>
</body>
</html>
