/**

Arrays 

-En JS los arreglos son colecciones de objetos

*/

var arr =[5,4,3,2,1]; //Array
console.log(arr);
console.log(arr[0],arr[4],arr[5]);

arr.reverse(); // Invierte ls posiciones del array
console.log(arr);

//Mapa permite iterar y devolver un nuevo array
//-Se utiliza para cambiar el valor de los elementos
arr = arr.map( function(elem){

	elem *=elem;
	return elem;

})

console.log(arr);

//
arr = arr.map(Math.sqrt);
console.log(arr);



//join devuelve un nuevo array
//convierte el array en un solo string y lo separa como indiquemos

arr= arr.join("|");
console.log(arr);


//split es lo contrario al join
arr= arr.split("|");
console.log(arr);


//push es para añadir valores al array, lo añade en la ultima posicion
arr.push("6");
console.log(arr);

//Añade en la primera posicion del array
arr.unshift("0");
console.log(arr);


//
console.log(arr.toString());



//pop elimina el ultimo elemento y devuelve el elemento eliminado
var eliminar = arr.pop();
console.log(arr);
console.log(eliminar);

//splice , puede recibir N paremetros
arr.splice(1, 1, "10","20","30");// empieza en la 1 posicion y elimina 1 posicion y añadimos el 10 , 20 y 30
console.log(arr);

arr.splice(1, 0, "40","50","60");// empieza en la 1 posicion no elimina nada y añade 3 valores
console.log(arr);


//slice para cortar devuelve un nuemo array
arr = arr.slice(0,2); //Empieza en la posicion 0 y devuelve los 2 primeros valores
console.log(arr);







