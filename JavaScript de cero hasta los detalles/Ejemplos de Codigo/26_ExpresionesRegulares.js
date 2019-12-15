/**

Expresiones Regulares

*/


var reg1 = RegExp("a");
var reg2 = /a/;


var texto = "Hola Mundo.";


var arr = texto.match(/^.o/); //Si existe regresa un array si no devuelve NULL

var arr2 = texto.match(/[0-9]/);

var arr3 = texto.match(/[a-zA-Z]/);

var arr4 = texto.match(/^H[a-zA-Z]/);

var arr5 = texto.match(/[a-zA-Z].$/);

var arr6 = texto.match(/[a-zA-Z0-9]/);

var arr7 = texto.match(/\w/);

var arr8 = texto.match(/\d/);


//i = insensible
//g = todas las apariciones
//m = multilinea
var arr9 = texto.match(/m/i);
var arr10 = texto.match(/[aeiou]/ig);

var arr11 = texto.match(/o{2}/);


console.log(arr);
console.log(arr2);
console.log(arr3);
console.log(arr4);
console.log(arr5);
console.log(arr6);
console.log(arr7);
console.log(arr8);
console.log(arr9);
console.log(arr10);