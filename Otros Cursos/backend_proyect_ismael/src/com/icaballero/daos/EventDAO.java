package com.icaballero.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icaballero.domain.Event;
import com.icaballero.exceptions.DAOException;
import com.icaballero.interfaces.daos.IEventDAO;
import com.icaballero.utils.FERSDataConnection;
import com.icaballero.utils.FERSDbQuery;

/**
 * 
 * Clase para gestionar la Conexion y las consultas de la Tabla SQL Event
 * @author Ismael Caballero
 *
 */
public class EventDAO implements IEventDAO {

	private Connection con = null;
	private PreparedStatement statment = null;
	private ResultSet result = null;
	private FERSDbQuery query = new FERSDbQuery();

	/**
	 * Constructor
	 * @param con conexion de la base de datos
	 */
	public EventDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Metodo que devuelve una lista con todos los eventos
	 * @return List<Event>
	 */
	public List<Event> showAllEvents() throws DAOException {
		List<Event> eventList = new ArrayList<Event>();
		try {

			statment = (PreparedStatement) con.prepareStatement(query.getAllEvents());
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

	/**
	 * Metodo que devuelve todos los eventos del mismo nombre
	 * @param Event 
	 * @return List<Event>
	 * 	 
	 **/
	public List<Event> showAllEvents(Event eventname) throws DAOException {
		List<Event> eventList = new ArrayList<Event>();
		try {

			statment = con.prepareStatement(query.getSearchByEventName());
			statment.setString(1, "%" + eventname.getName() + "%");
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
			throw new DAOException("Error en la consulta showAllEvents(name)");
		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);

		}

		return eventList;
	}

	/**
	 * Metodo que devuelve un Event
	 * @param eventID
	 * @return Event
	 */
	public Event getEvent(int eventId) throws DAOException {
		Event event = new Event();
		try {
			statment = con.prepareStatement(query.getGetEvent());
			statment.setInt(1, eventId);
			result = statment.executeQuery();

			while (result.next()) {
				event.setEventId(result.getInt("id"));
				event.setName(result.getString("name"));
				event.setDescription(result.getString("description"));
				event.setPlace(result.getString("places"));
				event.setDuration(result.getString("duration"));
				event.setEventType(result.getString("event_type"));
				event.setSeatsAEvent(result.getInt("seats_available"));
			}

		} catch (Exception e) {
			throw new DAOException("Error en la consulta getEvent");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return event;
	}

	/**
	 * Metodo para Modificar los datos de un evento
	 * @param Event
	 * @return 1 si es correcto -1 si es incorrecto
	 * 
	 */
	public int updateEvent(Event updateEvent) throws DAOException {
		int status = -1;

		try {
			statment = con.prepareStatement(query.getUpdateEvent());
			statment.setString(1, updateEvent.getName());
			statment.setString(2, updateEvent.getDescription());
			statment.setString(3, updateEvent.getPlace());
			statment.setString(4, updateEvent.getDuration());
			statment.setString(5, updateEvent.getEventType());
			statment.setInt(6, updateEvent.getSeatsAEvent());
			statment.setInt(7, updateEvent.getEventId());

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en updateEvent");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}


	/**
	 * Metodo que inserta un Evnet
	 * @param Event
	 * @return 1 si es correcto -1 si es incorrecto
	 */
	public int insertEvent(Event insertEvent) throws DAOException {
		int status = -1;

		try {
			statment = con.prepareStatement(query.getInsertEvent());
			statment.setInt(1, insertEvent.getEventId());
			statment.setString(2, insertEvent.getName());
			statment.setString(3, insertEvent.getDescription());
			statment.setString(4, insertEvent.getPlace());
			statment.setString(5, insertEvent.getDuration());
			statment.setString(6, insertEvent.getEventType());
			statment.setInt(7, insertEvent.getSeatsAEvent());

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en insertEvent");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

	/**
	 * Metodo que borra un evento
	 * @param eventID
	 * @return 1 si es correcto -1 si es incorrecto
	 */
	public int deleteEvent(int eventId) throws DAOException {
		int status = -1;

		try {
			statment = con.prepareStatement(query.getDeleteEvent());
			statment.setInt(1, eventId);

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en deleteEvent");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

	/**
	 * Metodo que Actualiza los asientos disponibles -1
	 */
	public int updateSeatsEventDec(Event event) throws DAOException {
		int status = -1;

		try {
			statment = con.prepareStatement(query.getUpdateSeatsEventDec());
			statment.setInt(1, event.getEventId());

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en updateSeatsEventDec");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

	/**
	 * Metodo que Actualiza los asientos disponible +1
	 */
	public int updateSeatsEventInc(Event event) throws DAOException {
		int status = -1;

		try {
			statment = con.prepareStatement(query.getUpdateSeatsEventInc());
			statment.setInt(1, event.getEventId());

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en updateSeatsEventInc");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

}
