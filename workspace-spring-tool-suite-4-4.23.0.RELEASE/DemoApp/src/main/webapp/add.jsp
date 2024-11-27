<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding both num</title>
</head>
<body bgcolor="cyan">
	<%
	
	int i = Integer.parseInt(request.getParameter("n1"));
	int j = Integer.parseInt(request.getParameter("n2"));
	int k = i + j;
	out.println(k);
	//out.println(k/0);
	%>

</body>
</html>