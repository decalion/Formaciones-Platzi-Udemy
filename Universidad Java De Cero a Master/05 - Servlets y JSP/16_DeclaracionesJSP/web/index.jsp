<%-- 
    Document   : index
    Created on : 26-may-2019, 14:57:01
    Author     : ismael
--%>
<%!
    //Declaramos una variable con su metodo get
    private String usuario ="Ismael";

    public String getUsuario(){
        return usuario;
    }
    //Declaramos un contador de visitas
    private int contadorVisitas = 1;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones</title>
    </head>
    <body>
        <h1>Uso de Declaraciones</h1>
        Usuario por medio del Atributo: <%= this.usuario%>
        <br>
        Usuario por medio del Metedo: <%= this.getUsuario() %>
        <br>
        Contador de Visitas desde que se reinicio el servidor:
        <%= this.contadorVisitas++ %>
    </body>
</html>
