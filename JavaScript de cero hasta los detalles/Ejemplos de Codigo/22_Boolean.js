/**

Boolean

*/


var a = true;
var b = false;
var c = new Boolean(); // false
var d = new Boolean("-1")//true
var e = new Boolean("-2")//true
var f = new Boolean("-0")//true
var g = new Boolean(0)//false
var h = new Boolean(1)//true
var i = new Boolean(null)//false
var j = new Boolean(undefined)//false
var k = new Boolean("")//false
var l = new Boolean(b)//true

console.log(a);
console.log(b);
console.log(c);
console.log(d);
console.log(e);
console.log(f);
console.log(g);
console.log(h);
console.log(i);
console.log(j);
console.log(k);
console.log(l);

if(c){ //Valida si c existe

	console.log("imprime");
}

if(c == true){ //Valida si es true

	console.log("imprime2");
}



