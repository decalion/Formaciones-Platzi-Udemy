<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="006BucleRequest.jsp">

<select name="numero">

<%for (int i=0; i<10;i++){ %>
<option value="<%=i%>"><%=i%></option>

<%} %>
</select>

<input type="submit" value="enviar">
</form>

</body>
</html>