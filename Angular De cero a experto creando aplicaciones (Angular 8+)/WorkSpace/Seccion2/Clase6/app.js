var miFuncion = function (a) {
    return a;
};
var miFuncionF = function (a) { return a; };
var miFuncion2 = function (a, b) {
    return a + b;
};
var miFuncion2F = function (a, b) { return a + b; };
var miFuncion3 = function (nombre) {
    nombre = nombre.toUpperCase();
    return nombre;
};
var miFuncion3F = function (nombre) {
    nombre = nombre.toUpperCase();
    return nombre;
};
var nombre = "Pedro";
var hulk = {
    nombre: "Bruce",
    smash: function () {
        var _this = this;
        setTimeout(function () { return console.log(_this.nombre + " smash"); }, 1500);
    }
};
hulk.smash();
console.log(miFuncion("Normal"));
console.log(miFuncionF("Flecha"));
