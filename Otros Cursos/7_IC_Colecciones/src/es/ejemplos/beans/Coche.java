package es.ejemplos.beans;

public class Coche
{
    private String marca;
    private String modelo; 
    private int age;
    private int km;


    
    public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getKm() {
		return km;
	}



	public void setKm(int km) {
		this.km = km;
	}



	@Override
    public String toString()
    {
        return new StringBuilder("Marca: ").append(marca).append(", modelo: ").append(modelo).append(", Año: ").append(age).append(", Km: ").append(km).toString();
    }
}
