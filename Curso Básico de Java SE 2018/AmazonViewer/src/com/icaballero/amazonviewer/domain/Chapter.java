package com.icaballero.amazonviewer.domain;

import java.util.ArrayList;

public class Chapter extends Movie {
	
	private int id;
	private int seassonNumber;
	private Serie serie;
	
	
	public Chapter(String title, String genre, String creator, int duration, short year, int seassonNumber,Serie serie) {
		super(title, genre, creator, duration, year);
		this.seassonNumber = seassonNumber;
		this.serie = serie;
	}

	
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
		}
		
		return chapters;
	}
	
	
	
	

	public Serie getSerie() {
		return serie;
	}



	public void setSerie(Serie serie) {
		this.serie = serie;
	}



	@Override
	public int getId() {
		return this.getId();
	}


	public int getSeassonNumber() {
		return seassonNumber;
	}

	public void setSeassonNumber(int seassonNumber) {
		this.seassonNumber = seassonNumber;
	}
	
	
	@Override
	public String toString() {

		return "\n :: CHAPTER ::" +
				"\n Title: " + getTitle() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration " + getDuration();
	}
	

}
