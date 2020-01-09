let avenger = {
    nombre : "Steve",
    clave : "Capitan America",
    poder: "Droga"
}

/*
let nombre = avenger.nombre;
let clave = avenger.clave;
let poder = avenger.poder;
*/

//Destructurando un objeto no importa el orden siempre que las propiedas
//Se llamen igual
let {clave, nombre,  poder } = avenger

console.log(nombre , clave , poder);


//Ejemplo de destructuracion de un array
//A diferencia de objetoses secuncial y el orden si que importa
let avengers:string[] = ["Thor","Steve","Tony"];

let [thor,capi,ironman] = avengers


console.log(thor,capi,ironman);







