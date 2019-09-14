package es.ejemplos.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service  //Con esta anotaci�n indicamos que la clase est� en una capa de servicios o de l�gica de negocios. 
//@Service(value="serv")  //usamos el atributo value si queremos poner un nombre diferente al bean.
public class Servicio {
    @Value(value="5")  //Con la anotaci�n Value asignamos un valor a la variable. 
    private Integer num1;
    @Value(value="2")
    private Integer num2;
	

	public Servicio(){
	}
	
	public int hacerOperacion(){
		return num1 + num2;
	}

}
