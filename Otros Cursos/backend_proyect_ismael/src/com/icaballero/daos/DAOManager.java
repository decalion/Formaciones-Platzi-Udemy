package com.icaballero.daos;

import java.sql.Connection;

import com.icaballero.interfaces.daos.IEventDAO;
import com.icaballero.interfaces.daos.IEventSignUpDAO;
import com.icaballero.interfaces.daos.ISequencerDAO;
import com.icaballero.interfaces.daos.IVisitorDAO;
import com.icaballero.utils.FERSDataConnection;




/**
 * Clase que crea las instancias de los daos con una conexion 
 * para tratar transacciones
 * 
 * @author Coritel
 *
 */
public class DAOManager {

	//Conexion de la base de datos
	private Connection conn;
	
	//Constructor 
	public DAOManager()
	{
		
		conn = FERSDataConnection.getConnection();
	
	}
	/**
	 * método que devuelve una instancia de un IEVentDAO
	 * 
	 * @return IEventDAO
	 */
	public IEventDAO getEventDAO()
	{
		return new EventDAO(conn);
		

	}
	/**
	 * método que devuelve una instancia de un IVisitorDAO
	 * 
	 * @return IVisitorDAO
	 */
	public IVisitorDAO getVisitorDAO()
	{
		return new VisitorDAO(conn);
	}
	
	/**
	 * metodo que devuelve una instancia de un IEventSingUp
	 * @return IEventSignUpDAO
	 */
	public IEventSignUpDAO getEventSingUpDAO(){
		
		return new EventSignUpDAO(conn);
	}
	
	/**
	 * metodo que devuelve una instancia de un ISequencerDAO
	 * @return ISequencerDAO
	 */
	public ISequencerDAO getSequencerDAO(){
		
		return new SequencerDAO(conn);
	}
	
	/**
	 * método que hace commit y cierra la conexion
	 * 
	 */
	public void closeOK()
	{
		FERSDataConnection.commit(conn);
		FERSDataConnection.closeConnection(conn);
		
	}
	/**
	 * método que hace rollback y cierra la conexion
	 * 
	 */
	public void closeError()
	{
		FERSDataConnection.rollback(conn);
		FERSDataConnection.closeConnection(conn);
		
	}
}
