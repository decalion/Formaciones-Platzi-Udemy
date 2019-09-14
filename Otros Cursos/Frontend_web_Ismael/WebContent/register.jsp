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
			<h3>Register Your Information</h3>
		</div>
		<div class="updateForm">
			<p><i>Fields marked (*) are Mandatory</i></p><br/>
			<p>${requestScope.error}</p><br/>
			<form action="./register.do" >
				FirstName : <input type="text" name="firstName"><br/>
				LastName : <input type="text" name="lastName"><br/>
				UserName : <input type="text" name="userName"><br/>
				* Password : <input type="password" name="password"><br/>
				* Confirm Password : <input type="password" name="cpassword"><br/>
				Email : <input type="text" name="email"><br/>
				Phone No : <input type="text" name="phone"><br/>
				Address : <input type="text" name="addres"><br/>
				<a href="index.jsp"><input type="button" align="right" value="Back"></a>
				<input type="submit" align="right" value="Register">
			</form>
		</div>
	</div>
</body>
</html>