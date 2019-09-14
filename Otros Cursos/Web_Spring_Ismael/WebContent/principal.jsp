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
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="principalContent">
	<div class="principalTitle">
		<h1>Festival Registration System</h1>
	</div>
	<div class="principalMenu">
		<a href="./logout.do">Logout</a> 
		<a href="#">Event_Catalog</a> 
		<a href="#">About</a>
	</div>
	<div class="principalSubtitle">
	<h3>Festival Portal Page : Welcome ${sessionScope.visitor.firstName} to your portal page... </h3>
	</div>
	<div class="principalInfo">
		<p><b>Your personal information</b> <i>is below.To Change your information,</i><a href="update.jsp">click here</a> </p>
		<p><b>UserName : ${sessionScope.visitor.userName}</b></p>
		<p><b>VisitorID : ${sessionScope.visitor.visitorId}</b></p>
		<p><b>Email : ${sessionScope.visitor.email}</b></p>
		<p><b>Phone No : ${sessionScope.visitor.phoneNumber}</b></p>
		<p><b>Adress : ${sessionScope.visitor.addres}</b></p>
	</div>

	<div class="principalEventsUp">
		<p>To relase a Ticket you have for an up-coming attraction,please find the attraction below and click the release link </p><br/>
		<center>
			<table border="2">
				<tr>
					<td bgcolor="green" align="center">Confirmation#</td>
					<td bgcolor="green" align="center">Event id</td>
					<td bgcolor="green" align="center">Event Name</td>
					<td bgcolor="green" align="center">description</td>
					<td bgcolor="green" align="center">Places</td>
					<td bgcolor="green" align="center">Duration</td>
					<td bgcolor="green" align="center">Event Type</td>
					<td bgcolor="green" align="center">Action</td>
				</tr>
			<c:forEach var="list" items="${sessionScope.registerEvent}">
				<tr>
					<td align="center">1</td>
					<td align="center">${list.eventId}</td>
					<td align="center">${list.name}</td>
					<td align="center">${list.description}</td>
					<td align="center">${list.place}</td>
					<td align="center">${list.duration}</td>
					<td align="center">${list.eventType}</td>
					<td bgcolor="#9FF781" align="center"><a href="./unregisterEvent.do?eventId=${list.eventId}">Release</a></td>
				</tr>
			</c:forEach>
			</table>
		</center>
	</div>
	<div class="principalEvents">
		<p>To get a Ticket for an up-coming attraction, please find the attraction below, and click Register link </p><br/>
		<form action="./search.do">
				Enter eventname to search<input type="text" name="search"/>
				<input type="submit" value="Search"/>
	
		</form><br/>
		<center>
			<table border="2">
				<tr>
					<td bgcolor="green" align="center" >Event id</td>
					<td bgcolor="green" align="center">Event Name<a href="./EventNameDesc.do"><i class="fa fa-angle-up" style="font-size:24px"></i></a> <a href="./EventNameAsc.do"><i class="fa fa-angle-down" style="font-size:24px"></i></a></td>
					<td bgcolor="green" align="center">description</td>
					<td bgcolor="green" align="center">Places</td>
					<td bgcolor="green" align="center">Duration</td>
					<td bgcolor="green" align="center">Event Type</td>
					<td bgcolor="green"align="center">Avariable Tickets</td>
				</tr>
			<c:forEach var="list" items="${sessionScope.listEvents}">
				<tr>
					<td align="center">${list.eventId}</td>
					<td align="center">${list.name}</td>
					<td align="center">${list.description}</td>
					<td align="center">${list.place}</td>
					<td align="center">${list.duration}</td>
					<td align="center">${list.eventType}</td>
					<td bgcolor="#9FF781" align="center">${list.seatsAEvent}<br/><a href="./registerEventV.do?eventId=${list.eventId}">Register</a></td>
				</tr>
			</c:forEach>
			</table>
		</center>
	</div>
</div>
</body>
</html>