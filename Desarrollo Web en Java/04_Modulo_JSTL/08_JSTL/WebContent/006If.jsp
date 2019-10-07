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

<c:if test="${param.numero >= 5 }">
	<c:out value="Has aprobado"></c:out>
</c:if>

<c:if test="${param.numero < 5 }">
	<c:out value="Has suspendido"></c:out>
</c:if>

<br/>
<c:choose>
	<c:when test="${param.numero >= 5 }">
		<c:out value="Si que has aprobado"></c:out>
	</c:when>
	<c:otherwise>
		<c:out value="Si que has suspendido"></c:out>
	</c:otherwise>
</c:choose>


</body>
</html>