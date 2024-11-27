<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body>
    <h1>User Form</h1>
    <form action="TryCode" method="get">
        <label for="name"> Name: </label><br>
        <input type="text" name="name"><br>
        <label for="email"> E-mail: </label><br>
        <input type="email" name="email"><br>
        <label for="phone"> Phone: </label><br>
        <input type="tel" name="phone"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>