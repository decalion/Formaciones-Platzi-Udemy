/**

*/

window.onload = iniciaDatos;



/**
Funcion que se llama al cargar la pagina html
*/

function iniciaDatos() {
    document.getElementById("link").onclick = validaSalir;
    document.getElementById("linkSearch").onclick = busqueda;
}


/**
Funcion que valida si el usuario quiere salir
*/

function validaSalir(){
	
    if (confirm("Desea salir del sitio?")) {
        alert("Nos vamos a google");
        return true; //regresamos verdadero para salir
    }
    else {
        alert("Nos quedamos en el sitio");
        return false;//regresamos falso para quedarnos 

    }
}
	

/**
Funcion Que pide una cadena a buscar en google
*/


function busqueda(){
	
	/**
	Capturamos informacion del usuario
	*/
	var respuesta = prompt("Escribe la cadena a buscar:","");
	
	//Validamos si es el valor no es nulo
	if(respuesta){
		alert("Tu respuesta fue:" +respuesta);
		
		
		var nuevoLink = this +"search?q=" + respuesta;
		alert("Nuevo link:" + nuevoLink);
		
		//redirecionamos el link
		window.location=nuevoLink;
		
		//Regresamos false, ya que si no nos lleva al link original
		return false;
	}else{
		
		alert("No proporcionaste ninguna cadena a buscar");
		return false;
	}
	
}