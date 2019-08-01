const API_URL = "https://swapi.co/api/";
const PEOPLE_URL = "people/:id";

//En la URL añadimo la url de api y el paremetro de la peticion y remplazamos el id  por el id a obtener
//const URL= `${API_URL}${PEOPLE_URL.replace(":id",1)}`
const OPTS= {crossDomain: true};



//Funcion callback
const onResponse = function (persona){
  //console.log(arguments);
  console.log(`Hola yo soy ${persona.name}`);
}

function obtenerPersonaje(id){
    const URL =`${API_URL}${PEOPLE_URL.replace(":id",id)}`;
    $.get(URL, OPTS , onResponse);
}

obtenerPersonaje(1);
obtenerPersonaje(2);
obtenerPersonaje(3);


//lA FUNCION GET RECIBE 2 PAREMETROS La url de la peticion y las opciones + la funcion del callback
//$.get(URL, OPTS , onResponse)
