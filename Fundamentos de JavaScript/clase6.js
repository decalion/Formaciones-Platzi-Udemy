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


function imprimirNombreEnMayusculas({nombre}){
  console.log(nombre.toUpperCase());
}

imprimirNombreEnMayusculas(ismael);
imprimirNombreEnMayusculas(juan);
imprimirNombreEnMayusculas({nombre : "pepito"})
imprimirNombreEnMayusculas({apellido : "hernandez"});
