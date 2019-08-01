<%-- 
    Document   : reporteExcel
    Created on : 26-may-2019, 20:33:19
    Author     : ismael
--%>
<%@page import="util.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo="reporte.xls";
    response.setHeader("Content-Disposition", "inline; filename="+nombreArchivo);
 %>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte Excel</title>
    </head>
    <body>
        <h1>Reporte Excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha Inicio</th>
            </tr>
            <tr>
                <td>1.Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis básica de Java</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            <tr>
                <td>2.Programacion con Java</td>
                <td>Pondremos en practica concepto de la Programacion Orientada a Objetos</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
