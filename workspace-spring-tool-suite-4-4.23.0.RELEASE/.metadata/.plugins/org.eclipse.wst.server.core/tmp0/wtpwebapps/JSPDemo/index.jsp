<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert and Retrieve Records</title>
</head>
<body>

<h2>Insert Record</h2>
<form action="insert.jsp" method="post">
    Name: <input type="text" name="name" required /><br>
    Age: <input type="number" name="age" required /><br>
    <input type="submit" value="Insert Record" />
</form>

<h2>Retrieve Records</h2>
<form action="retrieve.jsp" method="get">
    <input type="submit" value="Show All Records" />
</form>

</body>
</html>
