package com.icaballero.amazonviewer.domain;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable{

	private int id;
	private int timeViewed;
	

	public Movie(String title, String genre, String creator, int duration,short year) {
		super(title, genre, creator, duration);
		
		this.setYear(year);
	}


	public static ArrayList<Movie> makesMovies(){
		ArrayList<Movie> movies = new ArrayList();
		
		for (int i = 1; i<=5; i++) {
			movies.add(new Movie("Movie "+ i, "Genero " +i, "Creador " +i, 120+1,(short)(2017+i)));
		}
		return movies;
		
	}

	
	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}



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


	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}




	
	
}
