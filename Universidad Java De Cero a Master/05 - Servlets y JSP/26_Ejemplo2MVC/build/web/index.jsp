<%-- 
    Document   : index
    Created on : 31-may-2019, 19:36:24
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo 2 MVC</title>
    </head>
    <body>
        <h1>Ejemplo 2 MVC</h1>
        <div style="color:red"> ${mensaje}</div>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador">
        Link al Servlet controlador sin parametros
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
        Link al Servlet controlador para agregar las variables
        </a>
        <br><br>
          <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
        Link al Servlet controlador para listar las variables
        </a>
    </body>
</html>
