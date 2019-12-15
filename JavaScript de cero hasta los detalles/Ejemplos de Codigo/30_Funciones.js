/**


En js todas la funciones tienen 3 metodos definidos en su prototipo
Call(),Apply() y Bind()

*/



//Ejemplo bind

var car = {
	color:"Blanco",
	marca:"Mazda",
	imprimir:function(){
		var salida = this.marca +" - " + this.color;
		return salida;
	}
}



var car2 = {
	color:"Rojo",
	marca:"Toyota"
}

console.log(car.imprimir());


var logCar = function (arg1,arg2){
	console.log("car: ", this.imprimir());
	console.log("Argumentos",arg1,arg2);
}

//logCar();//Devuelve error ya que la guncion imprimir no esta definida en el objeto global



var logModeloCar = logCar.bind(car) ;// Con el bind hacemos que apunte al objeto car

logModeloCar("abc","xzy");




//Ejemplo de call 
logModeloCar.call(car,"123","456");

//Ejemplo apply
logModeloCar.apply(car,["asd","qwe"]);



//Ejemplo de funciones prestadas
console.log(car.imprimir.call(car2));