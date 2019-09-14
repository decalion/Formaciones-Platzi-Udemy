<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Insert title here</title>
</head>
<body>
	<div class="updateContainer">
		<div class="updateTitle">
			<h2><a href="principal.jsp">Festival Registration System</a></h2>
		</div>
		<div class="updateMenu">
			<a href="./logout.do">Logout</a> 
			<a href="#">About</a>
		</div>
		<div class="updateSubTitle">
			<h3>Update Your Information</h3>
		</div>
		<div class="updateForm">
			<p><i>Fields marked (*) are Mandatory</i></p><br/>
			<p>${requestScope.error}</p><br/>
			<form action="./saveUpdateEvent.do" >
				* EventName : <input type="text" name="name" value="${sessionScope.event.name}"><br/>
				* Descripcion : <input type="text" name="desc" value="${sessionScope.event.description}"><br/>
				* Places : <input type="text" name="place" value="${sessionScope.event.place}"><br/>
				* Duration : <input type="text" name="duration" value="${sessionScope.event.duration}"><br/>
				* EventType : <input type="text" name="eventype" value="${sessionScope.event.eventType}"><br/>
				* Avaliable Tickets : <input type="text" name="seats" value="${sessionScope.event.seatsAEvent}"><br/>
				<a href="admin.jsp"><input type="button" align="right" value="back"></a>
				<input type="submit" align="right" value="update">
			</form>
		</div>
	</div>

</body>
</html>