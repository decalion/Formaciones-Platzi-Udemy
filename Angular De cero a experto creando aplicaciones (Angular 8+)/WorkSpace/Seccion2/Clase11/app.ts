//Ejemplo de decorador


function consola ( construcor:Function){

    console.log(construcor);
    
}



//El decorador(anotacion) lo que hace es enviar como paremetro el constructor
@consola
class Villano{


    constructor(public nombre:string){

    }

    
}