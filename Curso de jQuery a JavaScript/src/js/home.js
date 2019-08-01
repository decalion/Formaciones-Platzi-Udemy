console.log('hola mundo!');
const noCambia = "Ismael";

let cambia = "@IsmaelCaballero"

function cambiarNombre(nuevoNombre) {
  cambia = nuevoNombre
}


const  getUserAll = new Promise(function(todoBien,todoMal){
  // llamar a un api
  //setInterval
  setTimeout(function(){
    todoBien("Se acabo el tiempo");
  }, 5000)

})


const  getUser = new Promise(function(todoBien,todoMal){
  // llamar a un api
  //setInterval
  setTimeout(function(){
    todoBien("Se acabo el tiempo");
  }, 3000)

})

getUser.then(function(){
  //console.log("Todo bien");
}).catch(function(message){
  //console.log(message);
})

Promise.all([
  getUser,
  getUserAll,
]).then(function(message){
  //console.log(message);
}).catch(function(message){
  //console.log(message);
})


$.ajax('https://randomuser.me/api/',{
  method: 'GET',
  success: function(data){
    //console.log(data);
  },
  error: function(error){
  //  console.log(error);
  },
})

fetch('https://randomuser.me/api/').then(function (response){
  //console.log(response);
  return  response.json();
}).then(function(user){
  //console.log('user' , user.results[0].name.first);
}).catch(function(){
//  console.log("Fallo");
});


/*$.ajax({
  url: 'https://randomuser.me/api/',
  dataType: 'json',
  success: function(data) {
    console.log(data);
  }
});*/


/// codigo pagina

(async function load(){

async function getData(url){
    const response = await fetch(url);
    const data = await response.json();

    if(data.data.movie_count > 0){
      return data;
    }

    throw new Error('No se encontró ningun resultado');
  }

const $form = document.getElementById('form');
const $home = document.getElementById('home');
const $featuringContainer = document.getElementById('featuring');

function setAttributes($element, attributes){
  for (const key in attributes){
    $element.setAttribute(key,attributes[key]);

  }

}

const BASE_API ='https://yts.lt/api/v2/';

function featuringTemplate(peli){

  return (` <div class="featuring">
          <div class="featuring-image">
            <img src="${peli.medium_cover_image}" width="70" height="100" alt="">
          </div>
          <div class="featuring-content">
            <p class="featuring-title">Pelicula encontrada</p>
            <p class="featuring-album">${peli.title}</p>
          </div>
        </div>`
    )
 }

$form.addEventListener('submit', async (event)=>{
  event.preventDefault();
  $home.classList.add('search-active')

const $loader = document.createElement('img');

setAttributes($loader,{
  src: 'src/images/loader.gif',
  height: 50,
  width: 50
})
$featuringContainer.append($loader);
  const data = new FormData($form);

  try{
    const {data:{
      movies: peli
    }
    } = await getData(`${BASE_API}list_movies.json?limit=1&query_term=${data.get('name')}`)
    const HTMLString = featuringTemplate(peli[0]);
    $featuringContainer.innerHTML= HTMLString;

  }catch(error){
    alert(error.message);
    $loader.remove();
    $home.classList.remove('search-active');
  }

})


function videoItemTemplate(movie,category){

return ( `<div class="primaryPlaylistItem" data-id="${movie.id}" data-category="${category}">
     <div class="primaryPlaylistItem-image">
       <img src="${movie.medium_cover_image}">
     </div>
     <h4 class="primaryPlaylistItem-title">
       ${movie.title}
     </h4>
   </div>`)
}

function createTemplate(HTMLString){
  const html= document.implementation.createHTMLDocument();
  html.body.innerHTML = HTMLString;
  return html.body.children[0];

}

function addEventClick($element){
  $element.addEventListener('click',() =>{

    showModal($element);
  })
  //$('div').on('click' function)
}

function renderMovieList(list, $container, category){
  $container.children[0].remove();
 list.forEach((movie) =>{
   const HTMLString = videoItemTemplate(movie,category);
   const movieElement = createTemplate(HTMLString)
   $container.append(movieElement);
   const img = movieElement.querySelector('img');
   img.addEventListener('load', (event)=>{
     event.srcElement.classList.add('fadeIn')
   })
   addEventClick(movieElement);
})
}


async function cacheExist(category){
  const listName = `${category}List`;
  const cacheList =  window.localStorage.getItem(listName);
  if(cacheList){
      return JSON.parse(cacheList);
  }

  const {data:{ movies : data} }= await getData(`${BASE_API}list_movies.json?genre=${category}`);
  window.localStorage.setItem(listName, JSON.stringify(data));
  return data;
}


const actionList = await cacheExist('action');
const $actionContainer = document.querySelector('#action');
renderMovieList(actionList, $actionContainer, 'action');


const dramaList = await cacheExist('drama');
const $dramaContainer = document.getElementById('drama');
renderMovieList(dramaList, $dramaContainer, 'drama');


const animationList = await cacheExist('animation');
const $animationContainer = document.getElementById('animation');
renderMovieList(animationList, $animationContainer, 'animation');


const $modal = document.getElementById('modal');
const $overlay = document.getElementById('overlay');
const $hideModal = document.getElementById('hide-modal');

const $modalTitle = $modal.querySelector('h1');
const $modalImage = $modal.querySelector('img');
const $modalDescription = $modal.querySelector('p');


function findById(list, id){
  return list.find(movie => movie.id === parseInt(id, 10));
}

function findMovie(id,category){
  switch(category){
    case 'action':{
      return findById(actionList, id);
    }
    case 'drama':{
      return findById(dramaList, id);
    }
    case 'animation':{
      return findById(animationList, id);
    }
  }
}


function showModal($element){
  $overlay.classList.add('active');
  $modal.style.animation = 'modalIn .8s forwards';
  const id =  $element.dataset.id;
  const category = $element.dataset.category;

  const data = findMovie(id,category);
   $modalTitle.textContent = data.title;
   $modalImage.setAttribute('src',data.medium_cover_image) ;
   $modalDescription.textContent = data.description_full

}

function hideModal(){
  $overlay.classList.remove('active');
  $modal.style.animation = 'modalOut .8s forwards';

}


$hideModal.addEventListener('click', hideModal);


///// USERS FUNCTIONS ////////////////////


//Obtener los datos
async function getUser(url){

const response = await fetch(url);
const data = await response.json();

return data;

}



//crear plantilla
function templateUser(name,picture){

  return(`<li class="playlistFriends-item">
                <a href="#">
                  <img src="${picture}" alt="echame la culpa" />
                  <span>
                    ${name.first} ${name.last}
                  </span>
                </a>
              </li>`
  )
}


//Recorrer el array dde objetos y guardfar en el doom a traves de la plantilla
function addUserToList(list){

list.forEach( (user) =>{

  console.log(user);
  const HTMLString = templateUser(user.name,user.picture.thumbnail)
  const userElement = createTemplate(HTMLString)
  $userList.append(userElement);

})
}

const $userList = document.getElementById('userList');

const userList = await getUser('https://randomuser.me/api/?results=10');
addUserToList(userList.results);






})()


//Ejemplos de selectores
/*let $home = $('home .list #item');
let $home = document.getElementById('modal');
let $home = document.getElementClassName('modal');
let $home = document.getElementByTagName('div');
let $home = document.querySelector('.modal');
let $home = document.querySelectorAll('.modal');*/
