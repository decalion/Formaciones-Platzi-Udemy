<%-- 
    Document   : index
    Created on : 9 sept. 2019, 23:32:46
    Author     : ismael
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<String> lista = new ArrayList<>();
            lista.add("TV");
            lista.add("Stereo");
            lista.add("Telefono");
        %>

        <select>
            <%
                for (String string : lista) {
                    out.println("<option>" + string + "</option>");
                }

            %>
        </select>
    </body>
</html>
