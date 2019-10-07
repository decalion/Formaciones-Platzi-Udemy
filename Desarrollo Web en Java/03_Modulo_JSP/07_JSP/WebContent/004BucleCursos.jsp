<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		String curso1="Java";
		String curso2="Net";
		String curso3="PHP";
		
		List<String> listaCursos = new ArrayList<String>();
		listaCursos.add(curso1);
		listaCursos.add(curso2);
		listaCursos.add(curso3);
	
		for (String curso : listaCursos) {
	%>

	<p><%=curso%></p>

	<%
		}
	%>



</body>
</html>