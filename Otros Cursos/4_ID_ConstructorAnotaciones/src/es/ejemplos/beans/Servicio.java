package es.ejemplos.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.ejemplos.beans.interfaces.Operacion;

@Service
public class Servicio {

	private Operacion operacion; 
	
	public Servicio(){
	}

	//@Autowired
	//public Servicio(Operacion operacion){  //Si dejamos este contructor nos mostrará un error, 
											//porque no sabe cual de las clases que implementa la 
											//interfaz 'Operacion' debe inyecte ya que encuentra dos 
											//candidatas Suma y Resta. Para solucionar esto, tenemos la 
											//anotación '@Qualifier' para referirnos al bean que queremos usar.
	@Autowired
	//public Servicio(@Qualifier("resta")Operacion operacion){ 
	public Servicio(@Qualifier("suma")Operacion operacion){
		this.operacion = operacion;
	}
	
	public int hacerOperacion(){
		return operacion.calcular();
	}

}
