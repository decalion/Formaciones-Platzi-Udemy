//Diferencias entre var,let y const

let mensaje = "Hola";
var mensaje2 = "Hola";
const OPCIONES ="todas";

if(true){
    //Dentro de cada scope let y const actuan como variables diferentes

    let mensaje ="adios";
    var mensaje2 ="adios";
    const OPCIONES ="ninguna";
    console.log(OPCIONES);
    
    

}

console.log(mensaje);
console.log(mensaje2);
console.log(OPCIONES);


