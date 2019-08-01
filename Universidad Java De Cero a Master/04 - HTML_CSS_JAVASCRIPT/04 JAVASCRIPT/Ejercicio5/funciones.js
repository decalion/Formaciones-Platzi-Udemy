/**

*/
function sumar(){
	
	//Envolvemos todo el codigo en un bloque try y cath para procesar la excepcion
	
	try {
		
		//Pedimos el valor del operando a
		
		var a = prompt("Valor a:", "");
	
		
		//Validamos el parametro a , a! revisa si esta vacia o nula
		
		if(!a || isNaN(a)){
			
			throw new Error("Valor invalido de a :" + a);
		}
		
		//Pedimos el valor de back
		
		var b = prompt("Valor b:", "");
		
			//Validamos el parametro b , b! revisa si esta vacia o nula
		
		if(!b || isNaN(b)){
			
			throw new Error("Valor invalido de b :" + b);
		}
		
		/*Si no hay problemas hacemos la suma , hay que convertir los paremetros a int 
		 parseInt convierte a entero. Si no es entero no reasliz la suma si no concatena los valores. */
		 
		 var c = parseInt(a) + parseInt(b);
		 alert("La suma es :" + c);

	}catch(e){
		alert("El error es:" + e.message);
	}
	
}