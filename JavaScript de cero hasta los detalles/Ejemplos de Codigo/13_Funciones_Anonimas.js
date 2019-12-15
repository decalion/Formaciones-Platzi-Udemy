/**

Funciones Anonimas

-Cualquier variable de tipo var que declaremos se define en el objeto global
-Al estar defino en el objeto global podemos moficar el valor desde cualquier lugar

-Con las funciones anonimas evitamos moficar los objetos globales
-Una funcion anonima es una funcion que no tiene nombre;
*/


//Funcion anonima
(function(){

var b = 10;//La variable no existe en el objeto global

function cambiarA(){
	b = 20;
}

cambiarA();

console.log(b);

})();

var a = 10;

function cambiarA(){
	//Esta modificando la variable global
	a = 20;
}

cambiarA();

console.log(a);




//Ejemplo 2 de funcion anonima

function ejecutarFunction(fn){
	

	return fn() == 1 ? true : false;

}

console.log(

ejecutarFunction( function(){

	console.log("Funcion anonima ejecutada");
	return 1;
})

);