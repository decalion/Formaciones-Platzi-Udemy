const API_URL = "https://swapi.co/api/";
const PEOPLE_URL = "people/:id";

//En la URL añadimo la url de api y el paremetro de la peticion y remplazamos el id  por el id a obtener
//const URL= `${API_URL}${PEOPLE_URL.replace(":id",1)}`
const OPTS= {crossDomain: true};


function obtenerPersonaje(id){

  return new Promise((resolve, reject) => {
    const URL =`${API_URL}${PEOPLE_URL.replace(":id",id)}`;

    $.get(URL, OPTS , function(data){
      resolve(data);

    }).fail( () => reject(id))

  })

    //  console.log(`Sucedio un error. No se puedo obtener el personaje con id ${id}`);
}

function onError(id){
  console.log(`Sucedio un error. No se puedo obtener el personaje con id ${id}`);
}



obtenerPersonaje(1).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
  return obtenerPersonaje(2);
}).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
    return obtenerPersonaje(3);
}).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
  return obtenerPersonaje(4);
}).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
  return obtenerPersonaje(5);
}).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
  return obtenerPersonaje(6);
}).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
  return obtenerPersonaje(7);
}).then(personaje => {
  console.log(`Hola yo soy ${personaje.name}`);
}).catch(onError);
