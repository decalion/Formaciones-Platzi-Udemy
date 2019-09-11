<%-- 
    Document   : error
    Created on : 10 sept. 2019, 0:10:17
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuario ${user.name} no existe! </h1>
        <%@include file="index.jsp" %>
    </body>
</html>
