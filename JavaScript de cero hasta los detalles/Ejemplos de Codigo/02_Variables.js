/**
En java las Variables son de 2 tipos
Tipos Primitivos y Objetos

Hay 5 tipos primitivos
numeros,String,boolean , undefined y null

**/

//Tipos primitivos
var num = 10;
var str = "texto";
var bol = true;
var und = undefined;
var nul = null;


console.log( num );

//Cambia el tipo sin problemas
num = str;

console.log ( num);

bol = 10;
console.log ( bol);


//Objetos

var obj = {};// objetos vacio

var obj = {
	//propiedades
	numero  :10,
	texto  :"Ismael",


	objHijo : {
		numero2: 20,
		texto2: "Nuevo Texto"

	}

}; 

console.log(obj);