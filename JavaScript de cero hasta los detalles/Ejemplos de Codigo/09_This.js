/**

Metodos y This

-Para hacer referencia a una propieda del objeto estando dentro del objeto hay que utilizar this.
-Si no utilizamos this estamos llamando al objeto global
*/

//Contexto global
var nombre = "Juan Carlos";

var persona = {
	//Contexto persona

	nombre : "Ismael",
	apellido: "Caballero",
	imprimirNombre : function (){

		console.log(this);//Devuelve el objeto persona
		console.log(this.nombre + " " + this.apellido);
		console.log(nombre) // Llamamos al objeto global
	},
	direccion:{
		//Nuevo contexto Direccion
		pais: "España",
		obtenerPais: function(){
			console.log(this); // devuelve el objeto direccion
			console.log("La direccion es en " + this.pais)


			//Creamos una variable para guardar el objeto direccion
			var self = this;

			/**
				Al ser una variable de tipo var se define en el contexto global
			*/
			var nuevaDireccion = function(){
				console.log(this); //Devuelve el objeto Windows
				console.log(self);
				console.log("La direccion es en " + self.pais)
			}

			nuevaDireccion();
		}
	}

};


persona.imprimirNombre();
persona.direccion.obtenerPais();
