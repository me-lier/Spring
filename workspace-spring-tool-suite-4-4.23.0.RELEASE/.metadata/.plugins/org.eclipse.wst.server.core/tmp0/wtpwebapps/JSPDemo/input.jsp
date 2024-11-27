<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Input</title>
</head>
<body>
    <h1>User Input Form</h1>
    <form method="post" action="process.jsp">
        <label for="username">Enter your name:</label>
        <input type="text" id="username" name="username" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
