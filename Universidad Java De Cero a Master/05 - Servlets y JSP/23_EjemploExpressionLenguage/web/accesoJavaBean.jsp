<%-- 
    Document   : accesoJavaBean
    Created on : 30-may-2019, 20:54:36
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso JavaBean</title>
    </head>
    <body>
        <h1>Acceso JavaBean</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" />
        
        <!-- asignamos los valores del formulario al JavaBean -->
        <jsp:setProperty name="rectangulo" property="*" />
        <br>
        Valor base: ${rectangulo.base}
        <br>
        Valor Altura ${rectangulo.altura}
        <br>
        Valor Area : ${rectangulo.area}
        <br>
        Calculo area ${rectangulo.base * rectangulo.altura}
        <br>
        <br>
        <a href="index.jsp">Regreso al Inicio</a>
    </body>
</html>
