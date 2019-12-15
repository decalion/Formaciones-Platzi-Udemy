/**

String
*/

var b = "Caballero";
var a = new String("Ismael ");


console.log(a);
console.log(a[0]);
console.log(a["0"]);


console.log(a.toUpperCase());
console.log(a.toLowerCase());

var i = a.indexOf("s");
console.log("la letra esta en ",i)


 i = a.lastIndexOf("m");
console.log("la letra esta en ",i)


var nombre = a.substr(1,3);
console.log(nombre)

 nombre = a.substr(0,a.indexOf(" "));
console.log(nombre)

var split = a.split();
console.log(split);


//====
document.write(a.italics());
document.write(a.blink());
document.write(a.strike());
document.write(a.bold());


