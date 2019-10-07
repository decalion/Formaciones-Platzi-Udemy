<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
	int numero = Integer.parseInt(request.getParameter("numero"));
		for (int i = 0; i < numero; i++) {
	%>

	<p><%=i%></p>

	<%
		}
	%>



</body>
</html>