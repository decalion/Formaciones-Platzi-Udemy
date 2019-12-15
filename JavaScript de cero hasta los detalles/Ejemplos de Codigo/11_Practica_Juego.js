/**

Practica Juego Señor de los Anillos

*/


function Jugador(nombre){

	this.nombre = nombre;
	this.pv = 100; //Puntos de vida
	this.sp = 100; //Puntos de habilidad

	//Funcion para curar un jugador consume 40sp
	this.curar = function(jugadorObjetivo){

		if(this.sp >= 40){
			this.sp -= 40;
			jugadorObjetivo.pv += 20;
		}else{
			console.info(this.nombre + " No tiene SP");
		}

		this.estado(jugadorObjetivo);

	};



	this.tirarFlecha = function( jugadorObjetivo){
		
		if(jugadorObjetivo.pv > 40){
			jugadorObjetivo.pv -=40;
		}
		else{

			jugadorObjetivo.pv = 0;
			console.error(jugadorObjetivo.nombre + " murio!!");
		}
		

		this.estado(jugadorObjetivo);

	};

	this.estado = function( jugadorObjetivo){

		console.info(this);
		console.info(jugadorObjetivo);
	};




};





//Jugadores
var gandalf = new Jugador("Gandalf");
var legolas = new Jugador("Legolas");

console.log(gandalf);
console.log(legolas);

//Curamos
console.log(gandalf.curar(legolas));

