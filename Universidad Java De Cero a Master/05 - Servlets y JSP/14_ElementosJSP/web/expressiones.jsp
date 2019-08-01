<%-- 
    Document   : expressiones
    Created on : 25-may-2019, 19:50:42
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expresiones JSP</title>
    </head>
    <body>
        <h1>JSP de Expresiones</h1>
        Concatenacion : <%= "saludos " + "JSP" %>
        <br>
        Operaciones Matemaricas : <%= 2 * 3 / 2 %>
        <br>
        Session id : <%= session.getId() %>
        <br>
        <br>
        <a href="index.html">Regresar al Inicio</a>
    </body>
</html>
