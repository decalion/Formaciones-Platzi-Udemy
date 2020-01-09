var Avenger = /** @class */ (function () {
    function Avenger(nombre, equipo, nombreReal) {
        this.puedePelear = false;
        this.peleasGanadas = 0;
        console.log("Se ejecuto el constructor");
        this.nombre = nombre;
        this.nombreReal = nombreReal;
        this.equipo = equipo;
    }
    return Avenger;
}());
var antman = new Avenger("Antmant", "Capi", "Scott");
console.log(antman);
