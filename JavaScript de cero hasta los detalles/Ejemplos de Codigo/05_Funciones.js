/**
Funciones

Todas las funciones regresanun valor

**/

var a = 30;

function primeraFuncion(){

	//var a = 20;
	console.log(a);
}

primeraFuncion();

//devuelve undefined
var b = primeraFuncion();

console.log(b);

//Devuelve un objeto que es una funcion
var  miFuncion = primeraFuncion;
console.log(miFuncion);


miFuncion();