package com.icaballero.amazonviewer.domain;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {

	private int id;

	private String isbn;
	private boolean readed;
	private int timeReaded;

	public Book(String title, Date editionDate, String editorial,String[] authors) {
		super(title, editionDate, editorial);
		this.isbn = isbn;
		setAutores(authors);
	}
	
	

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}



	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeReaded(0);
		}
		
	}
	
	
	
	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors));
		}
		
		return books;
	}
	
	
	public String isReaded() {
		String leido = "";
		if(readed == true) {
			leido = "Sí";
		}else {
			leido = "No";
		}
		
		return leido;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	

	public boolean getIsReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String detailBook = "\n :: BOOK ::" + "\n Title: " + getTitle() + "\n Editorial " + getEditorial()
				+ "\n Edition Date: " + getEditionDate() + "\n Autors: ";
		
		for (String name : getAutores()) {
			detailBook += "\t" + name;

		}

		return detailBook;
	}


}
