
interface Xmen{
    nombre:string,
    poder:string
}




function enviarMission(xmen : Xmen){

    console.log("Enviando a: " + xmen.nombre);
    
};


function enviarCuartel(xmen : Xmen){

    console.log("Enviando al cuartel: " + xmen.nombre);
    
};



let wolverine:Xmen = {
    nombre: "Wolverine",
    poder: "Regeneracion"
};

enviarMission(wolverine);
enviarCuartel(wolverine);