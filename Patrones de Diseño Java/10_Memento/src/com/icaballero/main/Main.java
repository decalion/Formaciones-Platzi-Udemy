package com.icaballero.main;

import com.icaballero.memento.Article;
import com.icaballero.memento.ArticleMemento;
import com.icaballero.memento.CaraTaker;

public class Main {
	
	public static void main(String[] args) {
		probarMemento();
	}

	
	private static void probarMemento() {
		CaraTaker caraTaker = new CaraTaker();
		Article article= new Article("Ismael", "Mememento es una pelicula");
		article.setText(article.getText() + " de Nolan");
		
		System.out.println(article.getText());
		
		caraTaker.addMemento(article.createMemento());
		
		article.setText(article.getText() +" protagonizada por Guy Pearce");
		
		System.out.println(article.getText());
		
		caraTaker.addMemento(article.createMemento());
		
		ArticleMemento memento1 = caraTaker.getMemento(0);
		ArticleMemento memento2 = caraTaker.getMemento(1);
		
		System.out.println("------------------------");
		System.out.println(memento1.getText());
		System.out.println(memento2.getText());
		
		
		
		
	}
}
