<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h1>Simple Calculator</h1>
    <form method="post" action="calculator.jsp">
        <label for="num1">First Number:</label>
        <input type="text" id="num1" name="num1" required><br><br>
        <label for="num2">Second Number:</label>
        <input type="text" id="num2" name="num2" required><br><br>
        
        <label for="operation">Operation:</label>
        <select id="operation" name="operation">
            <option value="add">Add</option>
            <option value="subtract">Subtract</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
        </select><br><br>
        
        <input type="submit" value="Calculate">
    </form>

    <%
        // Retrieving form data
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");

        if (num1Str != null && num2Str != null && operation != null) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            // Performing the selected operation
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    out.println("<h2>Result: " + num1 + " + " + num2 + " = " + result + "</h2>");
                    break;
                case "subtract":
                    result = num1 - num2;
                    out.println("<h2>Result: " + num1 + " - " + num2 + " = " + result + "</h2>");
                    break;
                case "multiply":
                    result = num1 * num2;
                    out.println("<h2>Result: " + num1 + " * " + num2 + " = " + result + "</h2>");
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = num1 / num2;
                        out.println("<h2>Result: " + num1 + " / " + num2 + " = " + result + "</h2>");
                    } else {
                        out.println("<h2>Error: Division by zero is not allowed.</h2>");
                    }
                    break;
                default:
                    out.println("<h2>Invalid operation.</h2>");
            }
        }
    %>
</body>
</html>
