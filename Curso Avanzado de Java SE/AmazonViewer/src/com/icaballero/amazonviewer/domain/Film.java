package com.icaballero.amazonviewer.domain;

/**
 * <h1> Film </h1>
 * Film es una clase padre abstracta
 * <p>
 * Esta Clase es la clase base de la familia Films, como es abstracta
 * no pueden crease instancias. Contiene el metodo abstracto
 * {@code view()} que es obligatorio implementar para todo aquel que pertenezca a la familia.
 * 
 * @author Ismael Caballero
 * @version 1.1
 * @since 2019
 *
 */

public abstract class Film {
	
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;
	
	
	public Film(){
		
	}

	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}

	/**
	 * {@code view()} es un metodo abstracto obligatorio de implementar
	 */
	public abstract void view();
	
	public boolean getIsViewed(){
		return viewed;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String isViewed() {
		String visto ="";
		if(viewed == true){
			visto = "si";
		}
		else{
			visto = "no";
		}
		
		return visto;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	
	
	

}
