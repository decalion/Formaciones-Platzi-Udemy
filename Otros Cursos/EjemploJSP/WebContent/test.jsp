<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="persona" class="com.icaballero.bean.Persona" scope="session"/>
	<jsp:setProperty name="persona" property="*" />
	<%
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String older = null;
		if (edad >= 18) {
			older = "Eres Mayor de edad";
		} else {
			older = "Eres Menor de edad";
		}
		out.println("Nombre : " + nombre + "<br/> Edad: " + edad);
	%>

	<hr>
	<%=older%>
	<a href="test2.jsp">Click</a>

</body>
</html>