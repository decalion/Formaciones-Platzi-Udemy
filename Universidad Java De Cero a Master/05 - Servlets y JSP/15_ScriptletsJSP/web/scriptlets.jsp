<%-- 
    Document   : scriptlets
    Created on : 26-may-2019, 14:35:27
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Ejemplo de Scriptlets</title>
    </head>
    <body>
        <h1>Ejemplo de Scriptlets</h1>
        <br>
        <!-- scriptlets para enviar informacion al navegador -->
        <%
            out.println("Saludos desde un Scriptlets");
         %>
         <br>
         <%
             String nombreAplicacion = request.getContextPath();
             out.println("Nombre Aplicacion: " + nombreAplicacion);
          %>
          <br>
         <!-- scriptlets con codigo condicionado -->
         <%
             if(session != null && session.isNew()){
                 
          %>
          La sesion si es nueva
          <%
              } else if(session != null){
          %>
          La sesion no es nueva
          <%
              }
          %>
    </body>
</html>
