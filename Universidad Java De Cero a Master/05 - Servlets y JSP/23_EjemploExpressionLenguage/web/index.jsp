<%-- 
    Document   : index
    Created on : 30-may-2019, 20:54:00
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>23 Ejemplo Expression Lenguage</title>
    </head>
    <body>
        <h1>Ejemplo Expression Lenguage</h1>
        <br>
        <a href="vatiablesImplicitas.jsp?usuario=ismael">Objetos Implicitos</a>
        <br>
        <br>
        
        <!-- Entramos al JSP que accede al JavaBean -->
        Formulario HTML:
        <br>
        <form name="form1" action="accesoJavaBean.jsp">
            Base: <input type="text" name="base" />
            <br>
            Altura: <input type="text" name="altura"/>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
