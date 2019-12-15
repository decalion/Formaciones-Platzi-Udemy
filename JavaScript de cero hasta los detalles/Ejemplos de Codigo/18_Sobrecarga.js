/**

Sobrecarga de operadores

-En JS no se pueden sobrecargar los metodos. Siempre se queda con el ultimo metodo.

*/


function crearProducto(){

}



function crearProducto(nombre){

}
	



//Se queda con este metodo ya que es el ultimo los demas los ignora
function crearProducto(nombre,precio){


		nombre = nombre || "Sin nombre";
		precio = precio || 0;

		console.log("Producto: ", nombre, "Precio: ",precio)

	
}

/**
Ejemplo de sobrecarga
*/

function crearProducto100(nombre){

	crearProducto(nombre,100);
}

function crearProductoCamisa(precio){

	crearProducto("Camisa",precio);
}




crearProducto();
crearProducto("Lapiz")
crearProducto100("Goma de Borrar");
crearProductoCamisa("1000");


