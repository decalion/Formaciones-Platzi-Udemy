const API_URL = "https://swapi.co/api/";
const PEOPLE_URL = "people/:id";

//En la URL añadimo la url de api y el paremetro de la peticion y remplazamos el id  por el id a obtener
//const URL= `${API_URL}${PEOPLE_URL.replace(":id",1)}`
const OPTS= {crossDomain: true};


function obtenerPersonaje(id, callback){
    const URL =`${API_URL}${PEOPLE_URL.replace(":id",id)}`;


    $.get(URL, OPTS , callback).fail(function (){

      console.log(`Sucedio un error. No se puedo obtener el personaje con id ${id}`);
    });


}

obtenerPersonaje(1, function (persona) {
    console.log(`Hola yo soy ${persona.name}`);
  obtenerPersonaje(2, function(persona){
      console.log(`Hola yo soy ${persona.name}`);
    obtenerPersonaje(3 ,function (persona){
      console.log(`Hola yo soy ${persona.name}`);
    });
  });
});
