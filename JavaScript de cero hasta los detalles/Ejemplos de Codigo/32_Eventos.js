/**

Eventos

*/



function evento(arg){

	console.log("Clicar");
	console.log(arg);


}


var objeto = document.getElementById("objDemo");
console.log(objeto);


objeto.addEventListener("keypress",evento);




//Bloquear el click derecho del boton
document.onmousedown = function(arg){

	if (arg.button === 2){
			alert("Click derecho bloqueado");
	}
	
	console.log(arg);
}