/**
Ejemplo de Notacion de punto y  notacion de Cochertes

La notacion de punto es lo que nos permite obtener los valores de un objeto.

**/


var persona = {
	nombre: "Ismael",
	apellido: "Caballero",
	edad: 25,
	direccion:  {
		pais: "España",
		ciudad: "Madrid",
		edificio : {
			nombre : "Edificio principal",
			telefono: "2222-3333"
		}
	}
}

//Notacion de punto para obtener las propiedades
console.log(persona.nombre);
console.log(persona.direccion.pais);

//Añadir una nueva propiedad
persona.direccion.zipcode = 1111;
console.log(persona.direccion);


//Es muy largo de acceder
console.log(persona.direccion.edificio.telefono);

var edificio = persona.direccion.edificio;
edificio.nopiso = "8vo piso";

console.log(persona);


//Ejemplo de  notacion cocherte

var campo = "edad";

var campo2= "edad2";

console.log(persona["nombre"])
console.log(persona["direccion"]["pais"])
console.log(persona[campo])


//Devuelve undefine porque no encuentra la propiedad
console.log(persona.edad2)
console.log(persona[campo2])


