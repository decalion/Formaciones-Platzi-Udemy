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
			<form action="./update.do" >
				FirstName : <input type="text" name="firstName" value="${sessionScope.visitor.firstName}"><br/>
				LastName : <input type="text" name="lastName" value="${sessionScope.visitor.lastName}"><br/>
				UserName : <input type="text" name="userName" value="${sessionScope.visitor.userName}" disabled><br/>
				* Password : <input type="password" name="password"><br/>
				* Confirm Password : <input type="password" name="cpassword"><br/>
				Email : <input type="text" name="email" value="${sessionScope.visitor.email}"><br/>
				Phone No : <input type="text" name="phone" value="${sessionScope.visitor.phoneNumber}"><br/>
				Address : <input type="text" name="addres" value="${sessionScope.visitor.addres}"><br/>
				<a href="principal.jsp"><input type="button" align="right" value="back"></a>
				<input type="submit" align="right" value="update">
			</form>
		</div>
	</div>
</body>
</html>