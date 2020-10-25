package com.icaballero.holamundo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 2221044635969566691L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_persona;
	
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	
	

}
