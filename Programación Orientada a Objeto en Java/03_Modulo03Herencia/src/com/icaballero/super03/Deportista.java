package com.icaballero.super03;

public class Deportista extends Persona {
	
	private String deporte;
	

	public Deportista(String nombre) {
		//LLama al constructor de la clase superior
		super(nombre);

	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	
	@Override
	public void andar() {
		super.imprimeTextoAndar();
		System.out.println(" 10km/h");
	}
	

}
