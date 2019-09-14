<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"            
          prefix="c"%>
          
<table border="2">
	<tr>
		<td>ID</td>
		<td>EMAIL</td>
		<td>SOFTWARE</td>
		<td>OS</td>
		<td>PROBLEM</td>
	</tr>
<c:forEach var="supp" items="${sessionScope.suppList}">
	<tr>
		<td>${supp.id}</td>
		<td>${supp.email}</td>
		<td>${supp.software}</td>
		<td>${supp.os}</td>
		<td>${supp.problem}</td>
	</tr>

</c:forEach>         
</table>

</body>
</html>