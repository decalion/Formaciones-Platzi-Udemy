<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% String[] lista = new String[]{"Hola","que","tal","estas"};

pageContext.setAttribute("lista", lista);

%>
<body>

<c:forEach var="cadena" items="${lista}">
	<c:out value="${cadena}"></c:out>
</c:forEach>


</body>
</html>