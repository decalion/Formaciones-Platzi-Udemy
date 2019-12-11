/**

-Cualquier objeto de JavaScript se almacena en el objeto global window.
-JavaScript es case sensitive.
-Es un lenguaje interpretado.

-undefined y null son objetos diferentes a un que los 2 son objetos vacios.
-Si comparamos con el triple = da false ya que son objetos diferentes.
-En cambio con el doble = devuelve true ya que los 2 estan vacios.

undefined  === null
false

undefined  == null
true

**/

//Devuelve undefine
console.log(a);
console.log(b);
console.log(c);

var a = 1;
var b  ="Ismael";
var c = true;


console.log("Hola");
console.warn(a);
console.error(a);
console.info(a);


function imprimir(){
	for (var i = 0; i<8000; i++) {
		console.log("Imprimio");
	}
}

function presionoClick(){
	console.log("Click un boton");
}


imprimir();