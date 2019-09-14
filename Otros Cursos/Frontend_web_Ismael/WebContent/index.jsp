<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Festival DB Aplication</title>
</head>
<body>
	<div class="indexLogin">
		<div class="indexTitle">
			<h3>Festival Event Registration</h3>
		</div>
		<div class="indexSubTitle">
			<h3>Portal Login Page</h3>
		</div>
		<div class="indexError">
			${requestScope.error}
		</div>
		<div>
			<form action="./login.do">
				<br/>UserName <input type="text" name="username" size=14 /><br/>
				Password   <input type="password" name="password" size=14 /><br/>
				<input type="submit" value="login" align="left" />
			</form>
		</div>
		<div class="indexRegister">
		 New Visitor<br/>
		 <a href="register.jsp" >Register Here</a>
		</div>
	</div>
</body>
</html>