<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="mibean" class="com.icaballero.bean.TechSupportBean" scope="session"/>
<jsp:setProperty name="mibean" property="firstName" />
<jsp:setProperty name="mibean" property="lastName" />
<jsp:setProperty name="mibean" property="phoneNumber" />
<%
	mibean.registerCustomer();
	RequestDispatcher dispatcher = request.getRequestDispatcher("/response.jsp");
	dispatcher.forward(request, response);

%>

</body>
</html>