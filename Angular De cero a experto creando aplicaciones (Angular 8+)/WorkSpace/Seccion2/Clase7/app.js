var avenger = {
    nombre: "Steve",
    clave: "Capitan America",
    poder: "Droga"
};
/*
let nombre = avenger.nombre;
let clave = avenger.clave;
let poder = avenger.poder;
*/
//Destructurando un objeto no importa el orden siempre que las propiedas
//Se llamen igual
var clave = avenger.clave, nombre = avenger.nombre, poder = avenger.poder;
console.log(nombre, clave, poder);
//Ejemplo de destructuracion de un array
var avengers = ["Thor", "Steve", "Tony"];
var thor = avengers[0], capi = avengers[1], ironman = avengers[2];
console.log(thor, capi, ironman);
