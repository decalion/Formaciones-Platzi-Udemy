<%-- 
    Document   : jstlCore
    Created on : 30-may-2019, 21:26:28
    Author     : ismael
--%>

<!-- Con esta directiva importamos la libreria Core JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL CORE</title>
    </head>
    <body>
        <h1>JSTL CORE</h1>
        
        <!-- Manipulacion de Variables -->
        <c:set var="nombre" value="Ismael" />
        Variable Nombre : <c:out value="${nombre}" />    
        <br>
        <br>
        Variable con codigo HTML:
        <c:out value="<h1>Hla</h1>" escapeXml="true" />
        
        <br>
        <br>
        <!-- codigo condicionado uso de if -->
        <c:set var="bandera" value="true" />
        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
         <br>
         <!-- Codigo condicionado , similar swiitch -->
         <c:if test="${param.opcion !=null}">
             <c:choose>
                 <c:when test="${param.opcion == 1}">
                     <br>
                     Opcion 1 proporcionada
                     <br>
                 </c:when>
                 <c:when test="${param.opcion == 2}">
                     <br>
                     Opcion 2 Proporcionada
                     <br>
                 </c:when>
                 <c:otherwise>
                     <br>
                     Opcion proporcionada Desconocida ${param.opcion}
                     <br>
                 </c:otherwise>
             </c:choose>
         </c:if>
         <!-- iteracion de un arreglo -->
         <%
             //Uso de scriptles
             //Crearemos el arreglo com scriptlet(No es una buena practica)
             String[] nombres = {"Claudia","Pedro","Carlos","Ana"};
             
             //Compartimos el arreglo de nombres en el alcance (scope) de request
             request.setAttribute("nombres", nombres);
         %>
         <br>
         Lista de nombres en el arreglo
         <br>
         <ul>
             <c:forEach varStatus="status" var="persona" items="${nombres}">
                 <li>${status.count} - Nombre: ${persona}</li>
             </c:forEach>
         </ul>
         <br>
         <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
