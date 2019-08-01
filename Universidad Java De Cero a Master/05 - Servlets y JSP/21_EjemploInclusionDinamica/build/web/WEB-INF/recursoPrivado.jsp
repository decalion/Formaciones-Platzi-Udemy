<%-- 
    Document   : recursoPrivado
    Created on : 28-may-2019, 20:00:04
    Author     : ismael
--%>

<%
    String colorFondo = request.getParameter("colorFondo");
    
if(colorFondo == null || colorFondo.trim().equals("")){
    colorFondo="white";
}
 %>
 <body bgcolor="<%= colorFondo%>">
     Despliegue del contenido de un JSP privado en WEB-INF
 </body>
