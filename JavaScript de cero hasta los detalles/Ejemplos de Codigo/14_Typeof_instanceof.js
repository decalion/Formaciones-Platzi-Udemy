/**

Ejemplo de typeof y de instanceof

*/



function identificar(param){

	console.log( typeof param);

	if(typeof param == "function"){
		param();
	}else{
		console.log(param);
	}

	if(param instanceof Persona){

		console.log(param.nombre +"("+param.edad+")");
	}


}


function Persona(){

	this.nombre = "Ismael";
	this.edad=30;

}

var ismael = new Persona();

identificar(1);//number
identificar("hola");//string
identificar({});//object
identificar(ismael);//object
identificar(Persona);//function
identificar(function(){ console.log("Soy anonima");});//function