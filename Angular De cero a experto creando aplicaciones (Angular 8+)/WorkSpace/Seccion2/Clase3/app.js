//Diferencias entre var,let y const
var mensaje = "Hola";
var mensaje2 = "Hola";
var OPCIONES = "todas";
if (true) {
    //Dentro de cada scope let y const actuan como variables diferentes
    var mensaje_1 = "adios";
    var mensaje2 = "adios";
    var OPCIONES_1 = "ninguna";
    console.log(OPCIONES_1);
}
console.log(mensaje);
console.log(mensaje2);
console.log(OPCIONES);
