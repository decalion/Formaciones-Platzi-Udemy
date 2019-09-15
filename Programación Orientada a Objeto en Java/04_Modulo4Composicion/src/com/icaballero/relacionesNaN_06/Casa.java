package com.icaballero.relacionesNaN_06;

import java.util.ArrayList;

public class Casa {
	
	
	private String direccion;
	private ArrayList<Persona> personas;
	
	

	public boolean contains(Object o) {
		return personas.contains(o);
	}

	public boolean add(Persona e) {
		return personas.add(e);
	}

	public Casa(String direccion) {
		this.direccion = direccion;
		this.personas = new ArrayList<Persona>();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public int totalPersonas() {
		return personas.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casa other = (Casa) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}
	

}
