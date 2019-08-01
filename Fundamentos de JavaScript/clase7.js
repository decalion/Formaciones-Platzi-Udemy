var ismael = {
  nombre : "Ismael",
  apellido : "Caballero",
  edad: 29
}

var juan = {
  nombre : "Juan",
  apellido : "juanitoo",
  edad: 35

}


function imprimirNombreEnMayusculas(persona){
  //var nombre = persona.nombre
  var { nombre } = persona;
  console.log(nombre.toUpperCase());
}

function imprimirNombreYEdad({nombre , edad}){

  console.log(`Hola , me llamo ${nombre} y tengo ${edad} años`);
}



imprimirNombreEnMayusculas(ismael);
imprimirNombreEnMayusculas(juan);
//imprimirNombreEnMayusculas({nombre : "pepito"})
//imprimirNombreEnMayusculas({apellido : "hernandez"});

imprimirNombreYEdad(ismael);
imprimirNombreYEdad(juan);
imprimirNombreYEdad({nombre :"pepito" , edad : 55});
