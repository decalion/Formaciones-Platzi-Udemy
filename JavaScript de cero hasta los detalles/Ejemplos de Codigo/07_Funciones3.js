/**
	Funciones 3

-Una funcion puede Retornar, Primitivos, Objetos, Undefined o otra funcion	

Math.random()  -Devuelve un numero entre 0 y 1 sin contar el 1
*/


//Devuelve un numero
function obtenerAleatorio(){

	return Math.random();
}


console.log(obtenerAleatorio() + 10);

//Devuelve un String
function obtenerNombre(){

	return "Ismael ";
}

console.log(obtenerNombre() + "Caballero");

//Devuelve un boolean
function esMayor(){

	return obtenerAleatorio() > 0.5 ? true : false;
}

console.log(esMayor());

if(esMayor() ){
	console.log("Es mayor que 0.5");
}else{
	console.log("Es menor que 0.5");
}


//devuelve un objeto
function crearPersona(nombre,apellido){

		return {
			nombre : nombre,
			apellido : apellido

		}

}

var persona = crearPersona("Ismael","Caballero");
console.log(persona);
console.log(persona.nombre);



//Devuelve una funcion
function creaFunction(){

	return function(nombre){
		console.log("Me Creo!! " + nombre);

		return function(){
			console.log("Segunda Funcion")
		}
	}
}

var nuevaFuncion = creaFunction();
var segundaFuncion = nuevaFuncion(persona.nombre);
segundaFuncion();

