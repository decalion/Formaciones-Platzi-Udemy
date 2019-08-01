/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function desplegar(categoria){
    
    var menu = document.getElementById(categoria);
    
    if(menu.className == "ver_menu"){
        menu.className = "ocultar_menu";
    }else{
        menu.className = "ver_menu";
    }
}
