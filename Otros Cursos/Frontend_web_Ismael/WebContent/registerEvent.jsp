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
			<h2>Festival Registration System</h2>
		</div>
		<div class="updateSubTitle">
			<h3>Register an Event</h3>
		</div>
		<div class="updateForm">
			<p><i>Fields marked (*) are Mandatory</i></p><br/>
			<p>${requestScope.error}</p><br/>
			<form action="./registerEvent.do" >
				* EventName : <input type="text" name="name"><br/>
				* Descripcion : <input type="text" name="desc"><br/>
				* Place : <input type="text" name="place"><br/>
				* EventType : <input type="text" name="type"><br/>
				* Duration : <input type="text" name="duration"><br/>
				* Avariable Tickets : <input type="text" name="seats"><br/>
				<a href="admin.jsp"><input type="button" align="right" value="Back"></a>
				<input type="submit" align="right" value="Register">
			</form>
		</div>
	</div>
</body>
</html>