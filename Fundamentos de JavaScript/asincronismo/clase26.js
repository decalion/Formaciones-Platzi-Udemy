
class Persona{

  constructor(nombre, apellido,altura){

    this.nombre = nombre;
    this.apellido = apellido;
    this.altura = altura;
  }

saludar(fn){

  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);

  if(fn){
    fn(this.nombre,this.apellido);
  }
}

  soyAlto(){
    return this.altura > 1.8;
  }


}


class Desarrollador extends Persona {

  constructor(nombre, apellido,altura){
    super(nombre,apellido,altura);

  }

  saludar(fn){
    console.log(`Hola, me llamo ${this.nombre} ${this.apellido} y soy desarrollador`);
    if(fn){
      fn(this.nombre,this.apellido,true);
    }
  }

}




function responderSaludo(nombre, apellido, esDev){

  console.log(`Buen dia ${nombre} ${apellido}`);
  if(esDev){
    console.log(`No sabia que eras Desarrollador`);
  }

}



var ismael = new Persona("Ismael","Caballero",1.64);
var gerard = new Persona("Gerard","Exposito",1.70);
var cristian = new Desarrollador("Cristian","Bautista",1.90);

ismael.saludar();
gerard.saludar(responderSaludo);
cristian.saludar(responderSaludo);
