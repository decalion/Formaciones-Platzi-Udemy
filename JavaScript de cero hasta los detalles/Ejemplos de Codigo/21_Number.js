/**
Numbers

*/

var a = 10;//Primitivo
var b = new Number(10); //Objeto

console.log(a === b);//False
console.log(a == b);//True


a = a.toString(); //Convierte el valor en string

console.log(a)



a  = 10.456789
console.log(a.toFixed(2)); //Corta el numero en 2 decimales y lo redondea



a  = 10.456789
console.log(a);
console.log(a.toPrecision(3));


a  = 10
a *= 10000000000
a *= 10000000000
a *= 10000000000
console.log(a); //Aguanta hasta 308 exponentes