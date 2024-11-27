<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Arithmetic Operations</title>
</head>
<body>
<!-- Input form -->
    <h2>Enter two numbers</h2>
    <form method="get" action="arithmetic.jsp">
        <label>Number 1:</label>
        <input type="number" name="num1" required>
        <br><br>
        <label>Number 2:</label>
        <input type="number" name="num2" required>
        <br><br>
        <input type="submit" value="Calculate">
    </form>
<%
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");

    if (num1Str != null && num2Str != null) {
        // Convert input values to integers
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        // Calculate arithmetic results
        int sum = num1 + num2;
        int difference = num1 - num2;
        int product = num1 * num2;
        int quotient = num2 != 0 ? num1 / num2 : 0;
        int remainder = num2 != 0 ? num1 % num2 : 0;

        // Display results
        out.println("<h2>Results:</h2>");
        out.println("Sum: " + sum + "<br>");
        out.println("Difference: " + difference + "<br>");
        out.println("Product: " + product + "<br>");
        out.println("Quotient: " + quotient + "<br>");
        out.println("Remainder: " + remainder + "<br>");
    }
%>

</body>
</html>
