<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.icaballero.clases.Curso" %>
<%@page import="com.icaballero.servicios2.ServiciosCurso"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

ServiciosCurso sc = new ServiciosCurso();
Curso c = sc.buscarUno(request.getParameter("nombre"));


session.setAttribute("cursoElegido", c); %>

Objeto almacenada en session.

<a href="verSession.jsp">mostrar curso elegido</a>
</body>
</html>