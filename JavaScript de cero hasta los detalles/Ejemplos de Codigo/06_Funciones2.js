/**

Funciones 2

**/


function imprimir(nombre,apellido){

	//Si quitamos el apellido del parametro e intentamos 
	//mostrarlo por el log devuelve ReferenceError

//Si el apellido tiene valor apellido = apellido si no = xxx
//apellido = apellido || "xxx";

/*	if(apellido === undefined){
		apellido  ="xxx";
	}*/


	console.log(nombre + " " + apellido);

}


imprimir("Ismael","Caballero");

//Devuelve undefined en el 2n parametro
imprimir("Ismael");
//Devuelve undefined en los 2 parametros
imprimir();



//Ejwmplo de objetos

function imprimir2(persona){

	console.log(persona.nombre + " " + persona.apellido);

}


imprimir2({
	nombre:"Ismael",
	apellido:"Caballero"
})


function imprimir3(persona){

	console.log(persona.nombre + " " + persona.apellido);
	//Cambia el valor del objeto "Referencia"
	persona.nombre = "Maria"

}

var obj = {
	nombre:"Ismael",
	apellido:"Caballero"
}

imprimir3(obj)
//Ha cambiado el valor deel nombre , los objetos van siempre por referencia
console.log(obj)






//Enviar una funcion a una funcion

function imprimir4(fn){

	//Ejecutamos la funcion anonima
	fn();

}

var persona = {
	nombre:"Ismael",
	apellido:"Caballero"
}

imprimir4( function(){

	console.log("Funcion anonima");
});


var miFuncion = function(){
	console.log("Mi Funcion");
}

imprimir4(miFuncion)