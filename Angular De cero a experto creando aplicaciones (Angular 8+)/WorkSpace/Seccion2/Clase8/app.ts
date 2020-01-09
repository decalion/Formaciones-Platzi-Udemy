let prom1 = new Promise( function(resolve, reject){

    setTimeout ( ()=>{

        console.log("Promesa terminada");

        //Termina bien
        resolve();

        //Termina mal
        // reject()



    },1500);

});


console.log("Paso 1");



prom1.then( function () {
    console.log("Ejecutame cuando termine bien");
    

}, function(){
    console.error("EJecutame si todo sale mal!!");
    

} )

console.log("Paso 2");
