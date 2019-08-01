<%-- 
    Document   : setterParamJsp
    Created on : 29-may-2019, 21:02:08
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Que modifica un Bean por parametros</title>
    </head>
    <body>
        <h1>JSP Que modifica un Bean por parametros</h1>
        <!--Declaramos el JB a utilizar -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        Modificacion de los atributos
        <br>
        <br>
        <jsp:setProperty name="rectangulo" property="base" param="baseParam" />
        Nuevo valor base : <%= request.getParameter("baseParam")%>
        <br>
        <jsp:setProperty name="rectangulo" property="altura" param="alturaParam" />
        Nuevo Valor Altura: <%= request.getParameter("alturaParam") %>
        <br>
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
