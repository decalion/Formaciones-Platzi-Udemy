/**

Contexto de las funciones

*/


//CONTEXTO GLOBAL

function crearFunciones(){

	//CONTEXTO DE LA FUNCION


	var arr = [];
	var numero = 1;

	arr.push(

		(function(numero){
			
			//Creamos un numero contexto con el valor de numero

			return function(){
			console.log(numero);
			}


		})(numero)
		);



	numero = 2;
	arr.push(function(){
		console.log(numero);
	})


	numero = 3;
	arr.push(function(){
		console.log(numero);
	})

//CUANDO ACABA NUMERO VALE 3 , Y CUANDO SE LLAMA A CUALQUIER FUNCION LLAMA AL CONTEXTO

	return arr;
}

var funciones = crearFunciones();

funciones[0]();
funciones[1]();
funciones[2]();