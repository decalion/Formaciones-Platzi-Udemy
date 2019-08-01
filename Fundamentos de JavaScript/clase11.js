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


function imprimirProfesiones(persona){
    document.write("<b>${persona.nombre} es:</b>");
    console.log(`<b<${persona.nombre} es:</b> `);
    if(persona.ingeniero){
      console.log("Ingenriero");
    }
    if(persona.cocinero){
      console.log("cocinero");
    }
    if(persona.cantante){
      console.log("cantante");
    }
    if(persona.dj){
      console.log("dj");
    }
    if(persona.guitarrista){
      console.log("guitarrista");
    }
    if(persona.drones){
      console.log("drones");
    }
}

//imprimirProfesiones(ismael);

const MAYORIA_DE_EDAD = 18;

function esMayorDeEdad(persona){

  return persona.edad >= MAYORIA_DE_EDAD;
}

function imprimirSiEsMayorDeEdad(persona){

    if(esMayorDeEdad(persona)){
      console.log(`${persona.nombre} es mayor de edad`);
    }else{
      console.log(`${persona.nombre} es menor de edad`);
    }
}

imprimirSiEsMayorDeEdad(ismael);
