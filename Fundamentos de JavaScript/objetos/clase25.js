
class Persona{

  constructor(nombre, apellido,altura){

    this.nombre = nombre;
    this.apellido = apellido;
    this.altura = altura;
  }

saludar(){
  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);
}

  soyAlto(){
    return this.altura > 1.8;
  }


}

class Desarrollador extends Persona {

  constructor(nombre, apellido,altura){
    super(nombre,apellido,altura);

  }

  saludar(){
    console.log(`Hola, me llamo ${this.nombre} ${this.apellido} y soy desarrollador`);
  }

}





var ismael = new Persona("Ismael","Caballero",1.64);

ismael.saludar();

var cristian = new Desarrollador("Cristian","Bautista",1.90);

cristian.saludar();
