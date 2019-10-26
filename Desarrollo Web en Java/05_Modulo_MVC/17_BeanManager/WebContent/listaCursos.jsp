<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	
	
	$("#filtroNombre").keyup(function() {
	
		
	
			
			$.get("../rest/cursos/filtro/"+$(this).val(),function(datos) {
				
				$("tr").remove();
				if (Array.isArray(datos.curso)) {
					
					for (var i=0;i<datos.curso.length;i++) {
						
						var curso= datos.curso[i];
						generarTabla(curso);
						
					}	
					
				}else {
					
					generarTabla(datos.curso);
				}
					
			
			});
			
		
		
	})
	
	function generarTabla(curso) {
		
		$("#tabla1").append(
				"<tr><td>"+curso.nombre+"</td>"+
				"<td>"+curso.nivel+"</td>"+
				"<td><form action='../ServletControlador/borrar' method='post'>"+
				"<input type='hidden' name='nombre' value='"+curso.nombre+"' />"+
				"<input type='hidden' name='nivel'  value='"+curso.nivel+"' />"+
				"<input type='submit' value='borrar'/>"+
				"</form>"+
				"</td>"+
				"</tr>");	
	} 


});


</script>

</head>
<body>
filtro:<input type="text" name="filtroNombre" id="filtroNombre"/>



<table border="1px" id="tabla1">
<c:forEach var="curso" items="${listaCursos}">

<tr>
<td><c:out value="${curso.nombre}"/></td>
<td><c:out value="${curso.nivel}"/></td>
<td>
<form action="../ServletControlador/borrar" method="post">
<input type="hidden" name="nombre"  value="${curso.nombre}" />
<input type="hidden" name="nivel"  value="${curso.nivel}" />
<input type="submit" value="borrar"/>
</form>
</td>
</tr>
</c:forEach>

</table>
<form action="../ServletControlador/formularioInsertar">
<input type="submit" value="nuevo"/>
</form>


</body>
</html>