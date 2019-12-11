/**
Ejemplo de pasa por valor y Referencia

Las variables primitivas siempre se pasan por valor. Tienen un espacio de memoria diferente.
Los Objetos se pasan por referencia. Ocupan la misma posicionn de memoria

**/

//Pasa por valor

var a = 10;
var b = a;

console.log("a ",a);
console.log("b ",b);

a = 20;

console.log("a ",a);
console.log("b ",b);


//paso por referencia

var c = {
	nombre:"Ismael"
}
var d = c;

console.log("c ",c);
console.log("d ",d);

c.nombre = "Pepe";

console.log("c ",c);
console.log("d ",d);

d.nombre = "Pedro";

console.log("c ",c);
console.log("d ",d);