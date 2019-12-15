/**
	Argumentos

*/


var arguments  =10;

function miFuncion(a,b,c,d){

	if(arguments.length != 4){

		console.error("La funcion necesita 4 argumentos");
		return;
	}

	console.log(a+b+c+d);

	console.log(arguments);


};


miFuncion(20,30,40,50,{},function(){});

miFuncion(20,30,40,50);