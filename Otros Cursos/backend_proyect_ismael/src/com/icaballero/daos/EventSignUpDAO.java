package com.icaballero.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icaballero.domain.Event;
import com.icaballero.domain.EventSignUp;
import com.icaballero.exceptions.DAOException;
import com.icaballero.interfaces.daos.IEventSignUpDAO;
import com.icaballero.utils.FERSDataConnection;
import com.icaballero.utils.FERSDbQuery;

/**
 * Clase para gestionar la conexion y las consultas de la Tabla SQL EventSingUp
 * @author Ismael Caballero
 *
 */
public class EventSignUpDAO implements IEventSignUpDAO {

	private Connection conn;
	private PreparedStatement statment = null;
	private ResultSet result = null;
	private FERSDbQuery query = new FERSDbQuery();

	/**
	 * Constructor
	 * @param conn conexion de la base de datos
	 */
	public EventSignUpDAO(Connection conn) {

		this.conn = conn;
	}

	/**
	 * Metodo que comprueba si un visitor esta registrado en un evento
	 */
	@Override
	public boolean checkEventsofVisitor(EventSignUp eventSignUp) throws DAOException {
		boolean status = false;
		try {

			statment = conn.prepareStatement(query.getCheckEvent());
			statment.setInt(1, eventSignUp.getIdVisitor());
			statment.setInt(2, eventSignUp.getIdEvent());
			result = statment.executeQuery();
			
			if(result.next()){
				if(result.getInt("event_count")>0){
					
					status = true;
				}
			}


		} catch (Exception e) {

			throw new DAOException("Error en EventSingUpDAO checkEventsofVisitor");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

	/**
	 * Metodo para Eliminar un visitor de un evento
	 */
	@Override
	public void unregisterVisitorToEvent(EventSignUp eventSignUp) throws DAOException {
		try {

			statment = conn.prepareStatement(query.getDeleteEventQuery());
			statment.setInt(1, eventSignUp.getIdEvent());
			statment.setInt(2, eventSignUp.getIdVisitor());

			statment.executeUpdate();

		} catch (Exception e) {

			throw new DAOException("Error en EventSingUpDAO unregisterVisitorToEvent");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

	}

	/**
	 * Metodo para registrar un visitor a un evento
	 * @param EventSingUp
	 */
	@Override
	public void registerVisitorToEvent(EventSignUp eventSignUp) throws DAOException {
		try {

			statment = conn.prepareStatement(query.getRegisterQuery());
			statment.setInt(1, eventSignUp.getId());
			statment.setInt(2, eventSignUp.getIdVisitor());
			statment.setInt(3, eventSignUp.getIdEvent());

			statment.executeUpdate();

		} catch (Exception e) {

			//throw new DAOException("Error en EventSingUpDAO registerVisitorToEvent");
			 System.out.println(e.getMessage());

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

	}

	/**
	 * Metodo que elimina un Evento registrado
	 * @param eventId
	 */
	@Override
	public int deleteEventSignUp(int eventId) throws DAOException {
		int status = -1;
		try {

			statment = conn.prepareStatement(query.getDeleteEventSessionSignup());
			statment.setInt(1, eventId);

			status = statment.executeUpdate();

		} catch (Exception e) {

			throw new DAOException("Error en EventSingUpDAO deleteEventSignUp");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}
		return status;
	}

	/**
	 * Metodo que devuelve la lista de eventos Registrados
	 * @param EventSingUp
	 * @return List<Event>
	 */
	@Override
	public List<Event> registeredEvents(EventSignUp eventSingUp) throws DAOException {
		List<Event> eventList = new ArrayList<Event>();
		try {

			statment = conn.prepareStatement(query.getStatusQuery());
			statment.setInt(1, eventSingUp.getIdVisitor());
			result = statment.executeQuery();

			while (result.next()) {
				Event event = new Event();
				event.setEventId(result.getInt("id"));
				event.setName(result.getString("name"));
				event.setDescription(result.getString("description"));
				event.setPlace(result.getString("places"));
				event.setDuration(result.getString("duration"));
				event.setEventType(result.getString("event_type"));
				event.setSeatsAEvent(result.getInt("seats_available"));

				eventList.add(event);

			}

		} catch (Exception e) {
			throw new DAOException("Error en la consulta showAllEvents()");
		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);

		}

		return eventList;
	}

}
