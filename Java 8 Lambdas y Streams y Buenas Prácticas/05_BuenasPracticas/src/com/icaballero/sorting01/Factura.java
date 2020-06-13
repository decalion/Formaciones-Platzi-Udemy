package com.icaballero.sorting01;

public class Factura implements Comparable<Factura> {

	private int numero;
	private String concepto;
	private double importe;

	public Factura(int numero, String concepto, double importe) {
		super();
		this.numero = numero;
		this.concepto = concepto;
		this.importe = importe;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public int compareTo(Factura f) {

		if (this.getImporte() > f.getImporte()) {
			return 1;
		} else if (this.getImporte() == f.getImporte()) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", concepto=" + concepto + ", importe=" + importe + "]";
	}
	
	

}
