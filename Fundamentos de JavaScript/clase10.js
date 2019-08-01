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
    document.write("<b<${persona.nombre} es:</b>");
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

imprimirProfesiones(ismael);


function imprimirSiEsMayorDeEdad(persona){
  


}
