<%@page import="com.icaballero.servicios.ServiciosCurso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.icaballero.clases.Curso" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		
		ServiciosCurso sc = new ServiciosCurso();
		List<Curso> listaCursos = sc.buscarTodo();
		
	
		for (Curso curso : listaCursos) {
	%>

	<p><%=curso.getNombre()%>,<%=curso.getNivel()%></p>

	<%
		}
	%>



</body>
</html>