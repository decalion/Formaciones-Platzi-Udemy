/**

 Cookies

-Necistamos un servidor para trabajar con cookies

*/


var demo = "123;123*123'123/";
console.log(escape(demo));
console.log(unescape(escape(demo)));


function crearCookie(nombre,valor){

	valor = escape(valor);

	var hoy = new Date();
	hoy.setMonth(hoy.getMonth()+1);

	document.cookie = nombre+"="+valor+";expires="+hoy.toUTCString()+";";

}


function borrarCookie(nombre){

	var hoy = new Date();
	hoy.setMonth(hoy.getMonth()-1);

	document.cookie = nombre+"=x;expires="+hoy.toUTCString()+";";


}


function getCookie(nombre){

	var cookies = document.cookie;

	var cookieArr = cookies.split("; ");
	console.log(cookieArr);

	for(var i = 0; i<cookieArr.length; i++){

			var parArr = cookieArr[i].split("=");
			cookieArr[i]= parArr;


			if(parArr[0] === nombre){

				return unscape(parArr[1]);
			}

	}


	return undefined;



}



document.cookie = "nombre=ismael;"; // crear cookie
document.cookie = "apellido=caballero;";

var cookies = document.cookie;

console.log(cookies);