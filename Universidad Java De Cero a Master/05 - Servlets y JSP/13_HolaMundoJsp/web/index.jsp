<%-- 
    Document   : index
    Created on : 25-may-2019, 13:39:25
    Author     : ismael
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola Mundo JSP</title>
    </head>
    <body>
        <h1>Ejercicio Hola Mundo con JSPs</h1>
        <!--Imprimir cadenas con diferentes tecnologias -->
        <ul>
            <li>Hola Mundo HTML
            <li><% out.println("Hola Mundo con Scriptlets");%>
            <li> ${"Hola Mundo con Expression Lenguage (EL)"}   
            <li> <c:out value="Hola Mundo con JSTL" />
        </ul>
        <!-- Algunos valores del lado del Servidor -->
        <ul>
            <li> Hola : <%= new java.util.Date()%>
            <li> Nombre del contexto de la Aplicacion :
                <%= request.getContextPath()%>
            <li> Valor del parametro X:
                <%= request.getParameter("X")%>
        </ul>
    </body>
</html>
