<%@page import="es.coritel.codington.festival.domain.Visitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"            
          prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Admin Panel</title>
</head>
<body>
<div class="principalContent">
	<div class="principalTitle">
		<h1>Festival Registration System</h1>
	</div>
	<div class="principalMenu">
		<a href="./logout.do">Logout</a> 
		<a href="principal.jsp">My portal</a> 
		<a href="registerEvent.jsp">add Event</a> 
		<a href="#">About</a>
	</div>
	<hr>
	<div class="principalEvents">
		<form action="./search.do">
				Enter Eventname to search<input type="text" name="search"/>
				<input type="submit" value="Search"/>
	
		</form><br/>
		<center>
			<table border="2">
				<tr>
					<td bgcolor="green" align="center" >Event id</td>
					<td bgcolor="green" align="center">Event Name</td>
					<td bgcolor="green" align="center">description</td>
					<td bgcolor="green" align="center">Places</td>
					<td bgcolor="green" align="center">Duration</td>
					<td bgcolor="green" align="center">Event Type</td>
					<td bgcolor="green"align="center">Avariable Tickets</td>
					<td bgcolor="green"align="center">Update</td>
					<td bgcolor="green"align="center">Deleted</td>
				</tr>
			<c:forEach var="list" items="${sessionScope.listEvents}">
				<tr>
					<td align="center">${list.eventId}</td>
					<td align="center">${list.name}</td>
					<td align="center">${list.description}</td>
					<td align="center">${list.place}</td>
					<td align="center">${list.duration}</td>
					<td align="center">${list.eventType}</td>
					<td bgcolor="#9FF781" align="center">${list.seatsAEvent}<br/>Seats Left</td>
					<td bgcolor="#9FF781" align="center"><a href="./UpdateFormEvent.do?eventId=${list.eventId}">Update</a></td>
					<td bgcolor="#9FF781" align="center"><a href="./DeletedEvent.do?eventId=${list.eventId}">Deleted</a></td>
				</tr>
			</c:forEach>
			</table>
		</center>
	</div>
</div>
</body>
</html>