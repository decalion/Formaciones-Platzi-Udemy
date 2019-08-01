<%-- 
    Document   : getterJsp
    Created on : 29-may-2019, 21:01:41
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee valores del JavaBean</h1>
        <!-- Declaramos el javabean a utilizar
         si ya existe un bean en la sesion llamado "rectangulo",
        regresaa el mismo objeto -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        
        <!-- Recuperamos los valores y los desplegamos -->
        <br>
        Valor base : <jsp:getProperty name="rectangulo" property="base" />
        <br>
        Valor Altura <jsp:getProperty name="rectangulo" property="altura" />
        <br>
        <!-- En este caso, no importa que la propiedas no exista
        en el JavaBean solo con tener un metodo llamada getArea() es posible simular una propiedas -->
        
        Valor Area: <jsp:getProperty name="rectangulo" property="area" />
        <br>
        <br>
        <a href="index.jsp">Regresar a inicio</a>
    </body>
</html>
