/**
Ejemplo de Arrays 

*/


var arr = [
	true,
	{
		nombre:"Ismael",
		apellido : "Caballero"
	},
	function(){
		console.log("Estoy en un array!!");
	},
	function(persona){
		console.log(persona.nombre +" "+persona.apellido);
	},
	[	
		"juan",
		"carlos",
		"pepe",
		"maria",
		"olga",
			[

				"david",
				"cristian",
				"melissa",
				function(){
					console.log(this);
				}
			]
	]

];

console.log(arr.length);
console.log(arr);

console.log(arr[0]);
console.log(arr[1].nombre +" "+arr[1].apellido);
arr[2]();//Llamamos a la funcion
arr[3](arr[1]); //Llamamos a la funcion pasando el objeto 

console.log(arr[4][1]);//Devuelve carlos
console.log(arr[4][5]); // Devulve el array
console.log(arr[4][5][0])//Devuelve david


var arreglo2 = arr[4][5]; //Pasa por referencia
arreglo2[0] = "Ana";
console.log(arreglo2);
console.log(arr[4][5][0]); //Devuelve ana
arreglo2[3]();
