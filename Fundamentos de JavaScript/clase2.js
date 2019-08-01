var nombre = "Ismael" , apellido ="Caballero"

var nombreEnMayusculas = nombre.toUpperCase();
var apellidoEnMinusculas = apellido.toLowerCase();


var primeraLetraDelNombre = nombre.charAt(0);

var cantidadDeLetrasDelNombre = nombre.length;

var nombreCompleto = nombre + " " +apellido;

//Concatener con comilla invertida(Accentos)
var nombreComplet2 = `${nombre} ${apellido.toUpperCase()}`;

//Desde que posicion empieza y cuantos caracteres muestra
var str = nombre.substr(1,2);

//Obtener la ultima letra del nombreEnMayusculas
var ultimaLetranombre = nombre.charAt(nombre.length - 1);
