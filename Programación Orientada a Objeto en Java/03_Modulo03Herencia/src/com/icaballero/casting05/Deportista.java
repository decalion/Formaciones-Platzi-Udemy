package com.icaballero.casting05;

public class Deportista extends Persona {
	
	private String deporte;
	

	public Deportista(String nombre,String deporte) {
		//LLama al constructor de la clase superior
		super(nombre);
		this.deporte=deporte;

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
