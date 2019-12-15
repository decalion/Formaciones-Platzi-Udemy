/**

Control errores


try siempre necesita el catch o el finally el catch es opcional

*/


try{


	var a = 100;


	if(a ===100){
		throw 'error!!';

	}else{
		throw 'error';

	}

	
	console.log("El valor de a : ",a)

}catch(e){

	if(e === "error!!"){

		console.log("Error de Tipo 1");
	}

	if(e === "error"){

		console.log("Error de Tipo 2");
	}

	
}finally{

	console.log("Final")
}





//Ejemplo con el objeto Error


try{

	throw new Error("Error definido");
	
	console.log("Nunca se ejecuta");

}catch(e){

console.log(e);
console.log(e.message);
	
}finally{

	console.log("Final2")
}


//Ejemplo con objetos


try{

	throw{
		nombreError: "Error de tipo1",
		accion:"Leer datos",
		codeError: 23
	}
	
	console.log("Nunca se ejecuta");

}catch(e){

console.log(e);
console.log(e.nombreError);
console.log(e.accion);
console.log(e.codeError);
	
}finally{

	console.log("Final3")
}



//Ejemlo con funcion

try{

	throw function(){
		console.log("Funcion del throw...")
	}
	console.log("Nunca se ejecuta");

}catch(e){

	e();
	
}finally{

	console.log("Final4")
}



///Ejemplo

try{

	throw 1;

}catch(e){

registroError(e);

	
}finally{

	console.log("Final5")
}


function registroError(e){
	//Para enviar al servidor de BBD, peticiones ajax ... etc

	var ahora = new Date();

	console.log("Se Registro un error: ",e , "a las: ", ahora);


}