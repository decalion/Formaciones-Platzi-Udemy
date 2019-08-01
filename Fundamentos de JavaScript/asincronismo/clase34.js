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



/*
var promesas = ids.map(function(id){
  return obtenerPersonaje(id);
})
*/

function mostrarNombrePersonajes(personajes){

  for (var i = 0; i < personajes.length; i++) {
    var personaje = personajes[i];
    console.log(`Hola yo soy ${personaje.name}`)

  }

}

async function obtenerPersonajes(){
  var ids = [1,2,3,4,5,6,7];
  var promesas = ids.map(id => obtenerPersonaje(id) );

  try{
    var personajes = await Promise.all(promesas);
    mostrarNombrePersonajes(personajes);
  }catch(id){
    onError(id);
  }
}

obtenerPersonajes();










/*
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
*/
