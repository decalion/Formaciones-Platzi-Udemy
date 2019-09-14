package es.ejemplos.beans;

import es.ejemplos.beans.interfaces.Operacion;

public class Servicio {

	private Operacion operacion; 
	private String msg;
	
	public Servicio(){
	}
	
	public int hacerOperacion(){
		return operacion.calcular();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		System.out.println("He pasado por el setter de msg: "+msg);
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}




}
