<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.icaballero.clases.Curso" %>
<%@page import="com.icaballero.servicios2.ServiciosCurso"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ServiciosCurso sc = new ServiciosCurso();
	List<Curso> listaCursos = sc.buscarTodo();

%>



<form action="sessionImplicita.jsp">

<select name="nombre">

<%for (Curso c: listaCursos){ %>
<option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>

<%} %>
</select>

<input type="submit" value="enviar">
</form>

</body>
</html>