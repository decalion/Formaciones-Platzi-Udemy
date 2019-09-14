package es.ejemplos.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.ejemplos.beans.interfaces.Operacion;

@Service
public class Servicio {


	private Operacion operacion; 
	
	
	private String msg;
	
	public Servicio(){
	}

//	public Servicio(Operacion operacion){
//		this.operacion = operacion;
//	}
	
	public int hacerOperacion(){
		return operacion.calcular();
	}

	public String getMsg() {
		return msg;
	}

	@Value(value="Mensaje por anotación")
	public void setMsg(String msg) {
		this.msg = msg;
		System.out.println("He pasado por el setter de msg: "+msg);
	}

	public Operacion getOperacion() {
		return operacion;
	}

	@Autowired
	@Qualifier("suma")
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}




}
