/**

 Utilizando el new

 -En js no existe el concepto de clase como en Java

*/

function Persona(nombre,apellido){

	this.nombre = nombre;
	this.apellido = apellido;
	this.edad = 30;

	this.nombreCompleto = function(){
		return this.nombre + " " + this.apellido + "("+ this.edad + ")";
	}

}



var juan = {}; //Objeto vacio
var ismael =  new Persona("Ismael","Caballero"); // devuelve un objeto vacio de tipo Persona
var maria = Persona ; // Devuelve una funcion normal

console.log(juan);
console.log(ismael);//Al ser una funcion las variables pasan a ser globales
console.log(ismael.nombreCompleto());//Al ser un objeto las variables estan dentro del context del objeto
console.log(maria);
