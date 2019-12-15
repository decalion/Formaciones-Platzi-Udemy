/**

Prototype

-Con los prototipos podemos añadir mas atributos o metodos a nuestros objetos.
-El objetivo de los prototipos es hacer mas eficiente el uso de los objetos.
-Al crear una funcion con un prototipo hacemos que este solo 1 vez en memoria. 
-En cambio si definimos la funcion en el objeto se guarda en memoria por cada objeto que creamos.


*/

function Persona(){

	this.nombre = "Ismael";
	this.apellido = "Caballero";
	this.edad = 30;


}

//Esta funcion solo esta una vez en memoria
Persona.prototype.imprimirInfo = function(){
	console.log(this.nombre + " " +this.apellido +"(" + this.edad +")");

}

Persona.prototype.pais = "España";

var ismael = new Persona();
ismael.imprimirInfo();

console.log(ismael);
console.log(ismael.pais);


//Añadimos una nueva funcion a todos los primitivos de tipo number
//!No es recomendable añadir prototipos a las variables primitivas!
Number.prototype.esPositivo = function(){

	return this > 0 ? true : false;
}

var a = 1;
console.log(a.esPositivo());