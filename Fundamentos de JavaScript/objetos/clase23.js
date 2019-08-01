function Persona(nombre, apellido,altura){

  this.nombre = nombre;
  this.apellido = apellido;
  this.altura = altura;

}

Persona.prototype.saludar = function (){
  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);
}

Persona.prototype.soyAlto = function (){
  return this.altura > 1.8;
}

var ismael = new Persona("Ismael","Caballero",1.64);


//ismael.saludar();
