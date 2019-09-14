package es.ejemplos.beans;

import es.ejemplos.beans.interfaces.Operacion;

public class Servicio {

	private Operacion operacion; 
	
	public Servicio(){
	}

	public Servicio(Operacion operacion){
		this.operacion = operacion;
	}
	
	public int hacerOperacion(){
		return operacion.calcular();
	}

}
