package com.icaballero.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.icaballero.amazonviewer.domain.Book;
import com.icaballero.amazonviewer.domain.Chapter;
import com.icaballero.amazonviewer.domain.Magazine;
import com.icaballero.amazonviewer.domain.Movie;
import com.icaballero.amazonviewer.domain.Serie;
import com.icaballero.amazonviewer.util.AmazonUtil;
import com.icaballero.makereport.Report;

/**
 * <h1>AmazonViewer </h1
 * AmazonViewer es un programa que permite visualizar Movies,Series con sus respectivos Chapters,
 * Books y Magazines. Te permite Generar reportes generales y con fecha del dia.
 * <p>
 * Existen algunas reglas como que todos los elementos pueden ser viasualizado o leidos a excepcion
 * de los Magazines, estas solo pueden ser vistas a modo de exposicion sin ser leidas.
 * 
 * @author Ismael Caballero
 * @version 1.1
 * @since 2019
 *
 */
public class Main {

	static ArrayList<Movie> movies = new ArrayList<Movie>();
	static ArrayList<Serie> series = Serie.makeSeriesList();
	static ArrayList<Book> books= Book.makeBookList();
	
	public static void main(String[] args) {
		
		showMenu();
		
	}

	public static void showMenu(){
		
		int exit = 1;
		do {
			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("Selecciona el numero de la opci�n deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report today");
			System.out.println("0. Exit");
			
			//Leer respuesta del usuario
			int response = AmazonUtil.validateUserResponseMenu(0, 6);
			
			
			if (response == 0) {
				System.out.println(response);
				break;
				
			}
			
			switch (response) {
			case 0:
				System.out.println("Adios vuelve pronto");
				exit = 0;
				break;
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
		movies = Movie.makesMovies();
		do{
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			AtomicInteger atomicInteger = new AtomicInteger(1);
			movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement() +". "+ m.getTitle() + " Visto: " + m.isViewed()));
			/*
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 +". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			*/
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer respuesta
			int response = AmazonUtil.validateUserResponseMenu(0, movies.size());
			
			if(response == 0){
				exit = 0;
				showMenu();
			}
			if(response > 0){
			
			Movie movieSelected = movies.get(response-1);
			movieSelected.view();
			
			
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
				break;
			}
			
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.view();
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
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Le�do: " + books.get(i).isReaded());
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
				bookSelected.view();
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
		StringBuilder contentReport = new StringBuilder();
		
		movies.stream()
		.filter(m -> m.getIsViewed())
		.forEach(m ->contentReport.append(m.toString() + "\n"));
		
		//Predicate<Serie> seriesViewed = s -> s.getIsViewed();
		//Consumer<Serie> seriesEach = s -> contentReport.append(s.toString() + "\n")
		
		Consumer<Serie> seriesEach = s -> {
			ArrayList<Chapter> chapters = s.getChapters();
			chapters.stream().filter(c -> c.getIsViewed()).forEach(c -> contentReport.append(c.toString() + "\n"));
			
		};
		series.stream().forEach(seriesEach);
		
		
		books.stream()
		.filter(b-> b.getIsReaded())
		.forEach(b ->contentReport.append(b.toString() + "\n"));
		
/*
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
*/
		report.setContent(contentReport.toString());
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
