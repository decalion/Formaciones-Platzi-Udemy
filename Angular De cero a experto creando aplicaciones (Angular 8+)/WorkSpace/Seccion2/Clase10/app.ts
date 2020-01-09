
class Avenger{

    nombre:string;
    equipo:string;
    nombreReal:string;

    puedePelear:boolean = false;
    peleasGanadas:number = 0;


    constructor(nombre:string, equipo:string,nombreReal:string){
        console.log("Se ejecuto el constructor");

        this.nombre = nombre;
        this.nombreReal = nombreReal;
        this.equipo = equipo;
        
    }


}


let antman:Avenger = new Avenger("Antmant","Capi","Scott");

console.log(antman);
