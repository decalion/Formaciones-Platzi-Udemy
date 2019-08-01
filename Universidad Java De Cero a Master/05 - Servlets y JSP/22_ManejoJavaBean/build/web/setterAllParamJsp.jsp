<%-- 
    Document   : setterAllParamJsp
    Created on : 29-may-2019, 21:02:26
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
        
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        
        <!-- Modificamos todas las propiedas cuyo parametro 
        coincida con el nombre de la propiedas -->
        <jsp:setProperty name="rectangulo" property="*" />
        
        Se modificaron todos los atributos :
        <br>
        <br>
        Nuevo valor base : <%=request.getParameter("base")%>
        <br>
        Nuevo valor altura : <%=request.getParameter("altura")%>
        <br>
        <br>
        <a href="index.jsp">Regresar al inicio </a>
    </body>
</html>
