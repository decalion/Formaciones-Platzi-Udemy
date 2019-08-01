var ismael = {
  nombre : "Ismael",
  apellido: "Caballero",
  altura : 1.64,
  cantidadDeLibros: 204
}

var cristian = {
  nombre : "Cristian",
  apellido: "Bautista",
  altura : 1.90,
  cantidadDeLibros: 182
}

var gerard = {
  nombre : "Gerard",
  apellido: "Exposito",
  altura : 1.75,
  cantidadDeLibros: 190
}

var agusti = {
  nombre : "Agusti",
  apellido: "Montes",
  altura : 1.70,
  cantidadDeLibros: 200
}

var natalia = {
  nombre : "Natalia",
  apellido: "Exposito",
  altura : 1.71,
  cantidadDeLibros: 150
}

const esAlta = persona => persona.altura > 1.8;

var personas = [ismael,cristian,gerard,agusti,natalia];

var personasAltas = personas.filter(esAlta);

/*var personasAltas = personas.filter(function (persona){
  return persona.altura > 1.8;
});*/

const pasarAlturaACms = persona =>({
    ...persona,
    altura: persona.altura * 100
})

var personasCms = personas.map(pasarAlturaACms)

const reduce =(acum, {cantidadDeLibros}) =>  acum + cantidadDeLibros;

var totalDeLibros = personas.reduce(reduce,0);

console.log(`La cantidad de libros es de: ${totalDeLibros}`);
