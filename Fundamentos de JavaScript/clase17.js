var ismael = {
  nombre : "Ismael",
  apellido: "Caballero",
  altura : 1.64
}

var cristian = {
  nombre : "Cristian",
  apellido: "Bautista",
  altura : 1.90
}

var gerard = {
  nombre : "Gerard",
  apellido: "Exposito",
  altura : 1.75
}

var agusti = {
  nombre : "Agusti",
  apellido: "Montes",
  altura : 1.70
}

var natalia = {
  nombre : "Natalia",
  apellido: "Exposito",
  altura : 1.71
}


var personas = [ismael,cristian,gerard,agusti,natalia];

//console.log(personas[0].altura);
//console.log(personas[0]["altura"]);

for (var i = 0; i < personas.length; i++) {
  var persona = personas[i];
  console.log(`${persona.nombre} mide ${persona.altura}`);
  
}
