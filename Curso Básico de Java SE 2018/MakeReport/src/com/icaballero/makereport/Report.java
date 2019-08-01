package com.icaballero.makereport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Report {
	
	private String name;
	private String title;
	private String content;
	private String extension;
	
	
	
	
	public void MakeReport(){
		if((getName() != null) && (getTitle() !=null ) && (getContent()!=null)){
			
			//Crear archivo
			
			try {
				
				//Crea el fichero
				File file = new File(getName()+"."+getExtension());
				
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw =  new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(getContent());
				bw.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("Ingresa los datos del archivo");
		}
		
		
	}
	

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
	
	
	

}
