<%-- 
    Document   : index
    Created on : 28-may-2019, 19:59:07
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion dinamica</title>
    </head>
    <body>
        <br>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
        <br>
        <jsp:include page="recursoPublico.jsp" />
    </body>
</html>
