/**

Date

*/


var hoy = new Date();
var fechaMilisegundos = new Date(1);
//var fechaFija= new Date(anio,mes,dia.hora,minutos,seg,miliseg )
var fechaFija= new Date(2016,10,20);

console.log(hoy);
console.log(fechaMilisegundos);
console.log(fechaFija);



console.log(hoy.getFullYear());
console.log(hoy.getDate());
console.log(hoy.getHours());
console.log(hoy.getMilliseconds());
console.log(hoy.getSeconds());
console.log(hoy.getTime());//Representacion en milisegundos de la fecha


var fecha = new Date(2016,9,20);
console.log(fecha);
//console.log(fecha.setDate(25));



//Sumar  dias a una fecha
Date.prototype.sumarDias = function(dias){

	this.setDate( this.getDate() + dias )

	return this;

}

//Sumar Años
Date.prototype.sumarAnios = function(anios){

	this.setFullYear( this.getFullYear() + anios )

	return this;

}




console.log(fecha.sumarDias(5));
console.log(fecha.sumarAnios(1));


