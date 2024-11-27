<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Input Form</title>
</head>
<body>
    <h1>Input Form</h1>
    <form method="post" action="process_form.jsp">
        <label for="name">Enter your name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
