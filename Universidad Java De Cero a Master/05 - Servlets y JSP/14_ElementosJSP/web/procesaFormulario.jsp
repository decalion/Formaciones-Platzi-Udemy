<%-- 
    Document   : procesaFormulario
    Created on : 25-may-2019, 19:51:00
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processar el Formulario HTML</title>
    </head>
    <body>
        <h1>Resultado formulario</h1>
        Usuario : <%= request.getParameter("usuario") %>
        <br>
        Password : <%= request.getParameter("password") %>
        <br>
        <br>
        <a href="index.html">Regresar al Inicio</a>
    </body>
</html>
