package com.icaballero.amazonviewer.domain;

import java.util.ArrayList;
import java.util.Date;

import com.icaballero.amazonviewer.dao.MovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * 
 * @author Ismael Caballero
 *
 */
public class Movie extends Film implements IVisualizable,MovieDAO{

	private int id;
	private int timeViewed;
	
	
	public Movie(){
		
	}

	public Movie(String title, String genre, String creator, int duration,short year) {
		super(title, genre, creator, duration);
		
		this.setYear(year);
	}


	public static ArrayList<Movie> makesMovies(){
		Movie movies = new Movie();
		return movies.read();
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if(dateF.getTime() > dateI.getTime()){
		setTimeViewed((int)dateF.getTime() - (int)dateI.getTime());
		}else{
			setTimeViewed(0);
		}
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}


	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	
	
	@Override
	public String toString() {

		return "\n :: MOVIE ::" +
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration " + getDuration();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view() {
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		Date dateI = startToSee(new Date());
		
		
		for (int i = 0; i < 10000; i++) {
			System.out.println(".........");
			
		}
		
		//Terminar de ver
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("viste: " +  toString());
		System.out.println("Por " + getTimeViewed() + "milisegundos");
		
	}




	
	
}
