var ismael = {
  nombre : "ismael",
  apellido: "Caballero",
  edad:29,
  peso: 100
}


console.log(`Al inicio del año ${ismael.nombre} pesa ${ismael.peso}kg`);

const INCREMENTO_PESO=0.2;

const aumentarDePeso = persona => persona.peso +=INCREMENTO_PESO;
const adelgazar = persona => persona.peso -=INCREMENTO_PESO;
const comeMucho = () => Math.random() < 0.3;
const realizarDeporte = () => Math.random() < 0.4;

const META = ismael.peso -3;
var dias = 0;

while(ismael.peso > META){

  if(comeMucho()){
    aumentarDePeso(ismael);
  }
  if(realizarDeporte()){
    adelgazar(ismael);
  }

  dias++;
}


console.log(`Pasaron ${dias} dias hasta que ${ismael.nombre}`);
