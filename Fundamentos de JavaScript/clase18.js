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

const esAlta = persona => persona.altura > 1.8;

var personas = [ismael,cristian,gerard,agusti,natalia];

var personasAltas = personas.filter(esAlta);

/*var personasAltas = personas.filter(function (persona){
  return persona.altura > 1.8;
});*/

console.log(personasAltas);
