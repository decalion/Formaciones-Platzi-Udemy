package com.icaballero.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.icaballero.amazonviewer.domain.Book;
import com.icaballero.amazonviewer.domain.Chapter;
import com.icaballero.amazonviewer.domain.Magazine;
import com.icaballero.amazonviewer.domain.Movie;
import com.icaballero.amazonviewer.domain.Serie;
import com.icaballero.amazonviewer.util.AmazonUtil;
import com.icaballero.makereport.Report;

public class Main {

	static ArrayList<Movie> movies = Movie.makesMovies();
	static ArrayList<Serie> series = Serie.makeSeriesList();
	static ArrayList<Book> books= Book.makeBookList();
	
	public static void main(String[] args) {

		showMenu();
		
	}

	public static void showMenu(){
		
		int exit = 0;
		do {
			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("Selecciona el numero de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report today");
			System.out.println("0. Exit");
			
			//Leer respuesta del usuario
			int response = AmazonUtil.validateUserResponseMenu(0, 6);
			
			//Validar respuesta
			
			switch (response) {
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				makeReport(new Date());
				break;
			case 0:
				System.out.println("Adios vuelve pronto");
				exit = 0;
				break;
			default:
				System.out.println();
				System.out.println("...Selecciona una opcion!...");
				System.out.println();
				break;
			}
			
		} while (exit != 0);
		
		
	}
	
	public static  void showMovies(){
		int exit = 1;
		
		do{
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 +". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer respuesta
			int response = AmazonUtil.validateUserResponseMenu(0, movies.size());
			
			if(response == 0){
				showMenu();
			}
			if(response > 0){
			
			Movie movieSelected = movies.get(response-1);
			movieSelected.setViewed(true);
			Date dateI = movieSelected.startToSee(new Date());
			
			for (int i = 0; i < 10000; i++) {
				System.out.println(".........");
				
			}
			
			//Terminar de ver
			movieSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("viste: " +  movieSelected);
			System.out.println("Por " + movieSelected.getTimeViewed() + "milisegundos");
			
			}
			
			
		}while(exit != 0);
		
		
	}
	
	public static  void showSeries(){
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			for (int i = 0; i < series.size(); i++) { //1. Serie 1
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, series.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				showChapter(series.get(response-1).getChapters());
			}
			
			
		}while(exit !=0);
		
	}
	
	public static  void showChapter(ArrayList<Chapter> chaptersOfSerieSelected){
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
			
			if(response == 0) {
				exit = 0;
			}
			
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.setViewed(true);
				Date dateI = chapterSelected.startToSee(new Date());
				
				for (int i = 0; i < 100000; i++) {
					System.out.println("..........");
				}
				
				//Termine de verla
				chapterSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + chapterSelected);
				System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
			}
		}while(exit !=0);
		
	}
	
	public static  void showBooks(){
			int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isReaded());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, books.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.setReaded(true);
				Date dateI = bookSelected.startToSee(new Date());
				
				for (int i = 0; i < 100000; i++) {
					System.out.println("..........");
				}
				
				//Termine de verla
				bookSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Leíste: " + bookSelected);
				System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");
			}
			
		}while(exit !=0);
		
	}
	
	public static  void showMagazines(){
		ArrayList<Magazine> magazines = Magazine.makeMagazineList();
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
			
			for (int i = 0; i < magazines.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + magazines.get(i).getTitle());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, 0);
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			
		}while(exit !=0);
		
		
	}
	
	public static void makeReport(){
		Report report = new Report();
		report.setName("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
				
			}
		}
		
		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport += chapter.toString() + "\n";
					
				}
			}	
		}
		
		
		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";
				
			}
		}

		report.setContent(contentReport);
		report.MakeReport();
		System.out.println("Reporte Generado");
		System.out.println();
	}
	
	public static void makeReport(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setName("reporte" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		
		
		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
		dateString = dfNameDays.format(date);
		String contentReport = "Date: " + dateString + "\n\n\n";
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
				
			}
		}
		
		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport += chapter.toString() + "\n";
					
				}
			}
		}
		
		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";
				
			}
		}
		report.setContent(contentReport);
		report.MakeReport();
		
		System.out.println("Reporte Generado");
		System.out.println();
	}
	
	
	

}
