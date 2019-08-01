<%-- 
    Document   : fondoColor
    Created on : 26-may-2019, 14:35:01
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String fondo = request.getParameter("colorFondo");
    //Si no se envio un color ponemos un color por defecto
    if(fondo == null || fondo.trim().equals("")){
        fondo = "white";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cambio color de fondo</title>
    </head>
    <body bgcolor="<%=fondo%>">
        <h1>Fondo de color aplicado : <%= fondo %></h1>
        <br>
        <a href="index.html">Regresar al index</a>
    </body>
</html>
