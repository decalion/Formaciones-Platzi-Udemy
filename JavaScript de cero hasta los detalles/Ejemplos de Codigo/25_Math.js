/**

Math

*/

var PI = Math.PI;
var E = Math.E;

console.log(PI);
console.log(E);

var num1 = 10.456789;
console.log(num1);
console.log(Math.round(num1)); //Redondear
num1 = 10.456789;
console.log(Math.round(num1*100)/100); //obtener 2 decimales


console.log(Math.floor(num1)); //Quita todos los decimales


var rnd = Math.random();
console.log(rnd);


function randomEnter(min, max){

	return Math.floor(Math.random() * (max-min +1) + min);

}

console.log(randomEnter(1,6));


console.log(Math.sqrt(10));
console.log(Math.pow(7,2)); //Elevar 7 a la 2