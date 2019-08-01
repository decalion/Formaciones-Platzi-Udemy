var ismael = {
  nombre: "Ismael",
  apellido: "Caballero",
  edad: 29,
  ingeniero: true,
  cocinero: false,
  cantante: false,
  dj: false,
  guitarrista: false,
  drones:true
}


const MAYORIA_DE_EDAD = 18;

const esMayorDeEdad = ({ edad }) => edad >= MAYORIA_DE_EDAD;




function imprimirSiEsMayorDeEdad(persona){

    if(esMayorDeEdad(persona)){
      console.log(`${persona.nombre} es mayor de edad`);
    }else{
      console.log(`${persona.nombre} es menor de edad`);
    }
}

function permitirAcceso(persona){
  if(!esMayorDeEdad(persona)){
    console.log("Acceso Denegado");
  }
}




imprimirSiEsMayorDeEdad(ismael);
