<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number</title>
</head>
<body bgcolor="cyan">

	<%
		int i=Integer.parseInt(request.getParameter("n1"));
		int j=Integer.parseInt(request.getParameter("n2"));
		
		int k=i+j;
		
		out.println(k);
	%>
	
	<%=k*k %>
	

</body>
</html>