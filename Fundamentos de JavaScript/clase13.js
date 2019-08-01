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

for(var i = 1; i<=365; i++ ){
  var random = Math.random()

  if(random < 0.25){
    aumentarDePeso(ismael);
  }else if(random < 0.5){
      adelgazar(ismael);
  }

}



console.log(`Al Final del año ${ismael.nombre} pesa ${ismael.peso.toFixed(2)}kg`);
