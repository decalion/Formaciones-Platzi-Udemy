<%-- 
    Document   : desplegarVariables
    Created on : 31-may-2019, 19:37:00
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variable</h1>
        
        Variables de alcance resquest:
        ${mensaje}
        <br>
        <br>
        Variable en alcance session
        <br>
        Rectangulo:
        Base: ${rectangulo.base}
        Altura: ${rectangulo.altura}
        Area: ${rectangulo.area}
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/index.jsp">
            Regresar al Inicio
        </a>
    </body>
</html>
