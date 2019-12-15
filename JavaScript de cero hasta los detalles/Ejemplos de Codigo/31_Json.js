/**

JSON

*/

var objetoJSON = {

	nombre:"Ismael",
	edad:30,
	imprimir : function(){
		console.log(this.nombre + " " + this.edad);
	}
}


console.log("Objeto literal ",objetoJSON);

var jsonString = JSON.stringify(objetoJSON); //Convertir en json

console.log(jsonString);


var objetoDesdeJson = JSON.parse(jsonString);//Convertir de JSON a Object

console.log(objetoDesdeJson);


console.log(objetoDesdeJson.nombre);
console.log(objetoDesdeJson.edad);

