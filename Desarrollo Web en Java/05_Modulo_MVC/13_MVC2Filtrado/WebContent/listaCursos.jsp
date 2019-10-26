<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="../ServletControlador/filtrar" method="post">
	<input type="text" name="filtroNombre" />
	<input type="submit" value="filtrar"/>
</form>

<table border="1px">
	<tr>
		<td>Nombre</td>
		<td>Nivel</td>
	</tr>	
<c:forEach var="curso" items="${listaCursos}">
	<tr>
	<td><c:out value="${curso.nombre }"></c:out></td>
	<td><c:out value="${curso.nivel }"></c:out></td>
	<td>
		<form action="../ServletControlador/borrar" method="post">
			<input type="hidden" name="nombre" value="${curso.nombre }"/>
			<input type="hidden" name="nivel" value="${curso.nivel }"/>
			<input type="submit" value="borrar"/>
		</form>
	 </td>
	</tr>
</c:forEach>

</table>

<form method="post" action="ServletControlador/formularioInsertar">
<input type="submit" value="nuevo"/>

</form>


</body>
</html>