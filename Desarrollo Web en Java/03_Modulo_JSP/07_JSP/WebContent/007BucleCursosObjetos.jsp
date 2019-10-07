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
	
		Curso c1 = new Curso("Java",1);
		Curso c2 = new Curso("NET",1);
		Curso c3 = new Curso("PHP",2);
		
		List<Curso> listaCursos = new ArrayList<Curso>();
		listaCursos.add(c1);
		listaCursos.add(c2);
		listaCursos.add(c3);
	
		for (Curso curso : listaCursos) {
	%>

	<p><%=curso.getNombre()%>,<%=curso.getNivel()%></p>

	<%
		}
	%>



</body>
</html>