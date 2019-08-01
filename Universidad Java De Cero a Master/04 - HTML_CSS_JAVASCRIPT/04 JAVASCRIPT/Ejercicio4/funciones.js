/**

*/

window.onload = configuraSelect;


function configuraSelect(){
	//Este es el elemento seleccionado por defecto
	document.getElementById("selectFaq").selectedIndex = 0;
	document.getElementById("selectFaq").onchange = cambiaPagina;
	
}

function cambiaPagina(){
	
	var elemnentoSelect = document.getElementById("selectFaq");
	
	var nuevaPagina = elemnentoSelect.options[elemnentoSelect.selectedIndex].value;
	
	if(nuevaPagina != ""){
		window.location = nuevaPagina;
	}
	
	
}