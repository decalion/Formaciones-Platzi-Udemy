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
<c:out value="${param.nombre}"></c:out>
<c:set var="nombre" value="${param.nombre}" scope="session"> </c:set>
<a href="005Scope2.jsp"> ver datos en session</a>
</body>
</html>