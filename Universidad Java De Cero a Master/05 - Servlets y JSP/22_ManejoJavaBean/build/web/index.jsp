<%-- 
    Document   : index
    Created on : 29-may-2019, 21:01:02
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> 22 Ejemplo Java Bean</title>
    </head>
    <body>
        <h1>Ejemplo Java Bean</h1>
        <!--JSP para modificar valores -->
        <a href="setterJsp.jsp">Modificar Valores del JavaBean</a>
        <br>
        <!--JSP para leer valores -->
        <a href="getterJsp.jsp">Leer Valores del JavaBean</a>
        <br>
        <br>
        <!--JSP para recuperar parametros de un formulario -->
        Formulario 1:
        <br>
        <form name="form1" action="setterParamJsp.jsp">
            Base:<input type="text" name="baseParam">
            <br>
            Altura: <input type="text" name="alturaParam">
           <input type="submit" value="Enviar" >            
        </form>
        <br>
        Formulario 2:
        <br>
        <form name="form2" action="setterAllParamJsp.jsp">
             Base:<input type="text" name="base">
            <br>
            Altura: <input type="text" name="altura">
           <input type="submit" value="Enviar" > 
        </form>
    </body>
</html>
