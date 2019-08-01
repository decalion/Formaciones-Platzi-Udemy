

function validarForma(forma){
    //Validamos usuario
    var usuario = forma.usuario;
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    //validamos password
    var password = forma.password;
    if(password.value == "" || password.value.length < 3 ){
        alert("Debe proporcionar un password de al menos 3 caracteres");
        password.focus();
        password.select();
        return false;
    }
    //Validamos tecnologias de interes
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    //Revisamos si ha seleccionado alguno
    for (i = 0; i < tecnologias.length; i++) {
        if(tecnologias[i].checked){
            
            checkSeleccionado = true;
        }
    }
    
    if (!checkSeleccionado){
        alert("Debe proporcionar una tecnologia")
        return false;
    }
    
    // Validamos el Genero
    var generos = forma.genero;
    var radioSeleccionado = false;
    //Revisamos si se selecciono algun radio
    for (i = 0; i < generos.length; i++) {
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    if(!radioSeleccionado){
        alert("Debe seleccionar un Genero");
        return false;
    }

    
    //Validamos ocupacion
    var ocupaccion = forma.ocupaccion;
    if(ocupaccion.value == ""){
        alert("Debe Seleccionar una ocupacion");
        return false;
    }
    //Formulario valido
    alert("Formulario valido, enviando datos...");
    
    return true;
    
}


