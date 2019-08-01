package com.icaballero.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IcaballeroSession {
	
	 private Session session;

	
	
	public IcaballeroSession() {

	        //Se obtiene la configuracion del fiichero cfg
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        
	        //Se crea la conexion
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        
	        //Inicializar accion en la BBDD(Insert, select ..etc)
	         session = sessionFactory.openSession();
	         session.beginTransaction();
	}

	public Session getSession() {
	     
	        
	        return session;
	}
	

}
