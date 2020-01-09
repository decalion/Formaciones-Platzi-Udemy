
let nombre:string = "Juan";
let apellido:string =" Perez";
let edad:number = 32;


let texto = "Hola, " + nombre +" "+apellido+" ("+edad+")";

//Template literal
let texto2 = `Hola, ${ nombre } ${ apellido } (${ edad})`


console.log(texto);
console.log(texto2);

