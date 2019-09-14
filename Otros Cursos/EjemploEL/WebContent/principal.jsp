<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
<%   List<String> lista = new ArrayList<String>();
    lista.add("DatoLista 1");
    lista.add("DatoLista 2");
    pageContext.setAttribute("lista", lista);
%>

<table border=1>
	<tr>
		<th>Expression Language</th>
		<th>Valor EL</th>
		<th>Descripcion</th>
	</tr>
	<tr>
		<td>$ {param.txtNombre}</td>
		<td>${param.txtNombre}</td>
		<td>Valor del parametro pasado por peticion</td>
	</tr>
	<tr>
		<td>$ {param['txtNombre']}</td>
		<td>${param['txtNombre']}</td>
		<td>Valor del parametro pasado por peticion</td>
	</tr>
	<tr>
		<td>$ {requestScope.coche}</td>
		<td>${requestScope.coche}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {coche}</td>
		<td>${coche}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {sessionScope.persona}</td>
		<td>${sessionScope.persona}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {persona}</td>
		<td>${persona}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {applicationScope.varApplication}</td>
		<td>${applicationScope.varApplication}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {applicationScope["varApplication"]}</td>
		<td>${applicationScope["varApplication"]}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {sessionScope.persona.coche.marca}</td>
		<td>${sessionScope.persona.coche.marca}</td>
		<td>Acceso encadenado</td>
	</tr>	
	<tr>
		<td>$ {applicationScope["varApplication"]}</td>
		<td>${applicationScope["varApplication"]}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {lista[1]}</td>
		<td>${lista[1]}</td>
		<td></td>
	</tr>	
	<tr>
		<td>$ {header["Accept-Encoding"]}</td>
		<td>${header["Accept-Encoding"]}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {cookie["Galleta"].value}</td>
		<td>${requestScope.cookie["Galleta"].value}</td>
		<td></td>
	</tr>	
	<tr>
		<td>$ {pageContext.request.method}</td>
		<td>${pageContext.request.method}</td>
		<td></td>
	</tr>
	<tr>
		<td>$ {initParam.idContexto}</td>
		<td>${initParam.idContexto}</td>
		<td></td>
	</tr>	
	</table>	
</body>
</html>