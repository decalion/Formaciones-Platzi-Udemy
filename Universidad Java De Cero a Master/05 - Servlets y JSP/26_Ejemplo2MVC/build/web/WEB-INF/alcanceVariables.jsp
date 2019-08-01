<%-- 
    Document   : alcanceVariables
    Created on : 01-jun-2019, 20:52:50
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br>
        Variable Request:
        Base : ${rectanguloRequest.base}
        altura: ${rectanguloRequest.altura}
        Area: ${rectanguloRequest.area}
        <br><br>
         Variable Session:
        Base : ${rectanguloSession.base}
        altura: ${rectanguloSession.altura}
        Area: ${rectanguloSession.area}
        <br><br>
        Variable Application:
        Base : ${rectanguloApplication.base}
        altura: ${rectanguloApplication.altura}
        Area: ${rectanguloApplication.area}
        <br><br>
        <a href="${pageContext.request.contextPath}/index.jsp">
            Regresar al Inicio
        </a>
    </body>
</html>
