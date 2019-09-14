package com.icaballero.domain;

import com.icaballero.exceptions.DomainException;
import com.icaballero.utils.Validator;

/**
 * POJO class for Event
 * 
 * @author Ismael Caballero
 */
public class Event implements Comparable<Event> {

	// Longitud minima de EventName
	private final static int MIN_LONG_EVENTNAME = 1;

	// Longitud maxima de EventName
	private final static int MAX_LONG_EVENTNAME = 45;

	// Longitud Minima de Description
	private final static int MIN_LONG_DESCRIPTION = 1;

	// Longitud Maxima de Description
	private final static int MAX_LONG_DESCRIPTION = 45;

	// Longitud Minima de Place
	private final static int MIN_LONG_PLACE = 1;

	// Longitud Maxima de Place
	private final static int MAX_LONG_PLACE = 45;

	// Longitud Minima de Duration
	private final static int MIN_LONG_DURATION = 1;

	// Longitud Maxima de Duration
	private final static int MAX_LONG_DURATION = 45;

	// Longitud Minima de EventType
	private final static int MIN_LONG_EVENTYPE = 1;

	// Longitud Maxima de EventType
	private final static int MAX_LONG_EVENTYPE = 45;

	// Mensaje de Error de EventName
	private final static String MSG_ERROR_EVENTNAME = "Invalid Event Name";

	// Mensaje de Erro de Descripcion
	private final static String MSG_ERROR_EVENTDESCRIPCION = "Invalid Event Descripcion";

	// Mensaje de Error Place
	private final static String MSG_ERROR_EVENTPLACE = "Invalid Event Place";

	// Mensaje de Error de Duration
	private final static String MSG_ERROR_EVENTDURATION = "Invalid Event Duration";

	// Mensaje de error de Event Type
	private static final String MSG_ERROR_EVENTTYPE = "Invalid Event Type";

	// Mensaje de Erroe de seatsAvailable
	private static final String MSG_ERROR_SEATSAVAILABLE = "Invalid SeatsAvailable";

	private int eventId;// Identificador del evento

	private String name;// Nombre del evento

	private String description;// Descripción del evento

	private String place;// Lugar del evento

	private String duration;// Duración del evento

	private String eventType;// Tipo de evento

	private int seatsAEvent;// Asientos disponibles en el evento

	/**
	 * Constructor por defecto de Event, crea un evento vacio
	 */
	public Event() {
	}

	/**
	 * Constructor de copia, crea un objeto Event copiando los atributos de otro
	 * 
	 * @param event
	 *            Evento que se va a copiar
	 */
	public Event(Event event) {

		if (event != null) {
			this.eventId = event.getEventId();
			this.name = event.getName();
			this.description = event.getDescription();
			this.place = event.getPlace();
			this.duration = event.getDuration();
			this.eventType = event.getEventType();
			this.seatsAEvent = event.getSeatsAEvent();
		}
	}

	/**
	 * Metodo que devuelve el EventID
	 * 
	 * @return
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * Metodopara guardar el event ID
	 * 
	 * @param eventId
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * Metodo que devuelve el Name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo para guardar el Name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (Validator.validateLongitud(name, MIN_LONG_EVENTNAME, MAX_LONG_EVENTNAME)) {
			this.name = name;
		} else {
			throw new DomainException(MSG_ERROR_EVENTNAME);
		}

	}

	/**
	 * Metodo que devuelve la Descripcion
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que guarda la descripcion
	 * 
	 * @param description
	 */
	public void setDescription(String description) {

		if (Validator.validateLongitud(description, MIN_LONG_DESCRIPTION, MAX_LONG_DESCRIPTION)) {
			this.description = description;
		} else {
			throw new DomainException(MSG_ERROR_EVENTDESCRIPCION);
		}

	}

	/**
	 * Metodo que devuelve la Place
	 * 
	 * @return
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Metodo para guardar la Place
	 * 
	 * @param place
	 */
	public void setPlace(String place) {
		if (Validator.validateLongitud(place, MIN_LONG_PLACE, MAX_LONG_PLACE)) {
			this.place = place;
		} else {
			throw new DomainException(MSG_ERROR_EVENTPLACE);
		}

	}

	/**
	 * Metodo que devuelve la longitud
	 * 
	 * @return
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Metodo para guardar la longitud
	 * 
	 * @param duration
	 */
	public void setDuration(String duration) {
		if (Validator.validateLongitud(duration, MIN_LONG_DURATION, MAX_LONG_DURATION)) {
			this.duration = duration;
		} else {
			throw new DomainException(MSG_ERROR_EVENTDURATION);
		}

	}

	/**
	 * Metodo que devuelve el Event Type
	 * 
	 * @return
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * Metodo para guardar el event Type
	 * 
	 * @param eventType
	 */
	public void setEventType(String eventType) {
		if (Validator.validateLongitud(eventType, MIN_LONG_EVENTYPE, MAX_LONG_EVENTYPE)) {
			this.eventType = eventType;
		} else {
			throw new DomainException(MSG_ERROR_EVENTTYPE);
		}

	}

	/**
	 * Metodo que devuelve seatsAEvents
	 * 
	 * @return
	 */
	public int getSeatsAEvent() {
		return seatsAEvent;
	}

	/**
	 * Metodo pra guardar seatsAEvents
	 * 
	 * @param seatsAEvent
	 */
	public void setSeatsAEvent(int seatsAEvent) {
		if (seatsAEvent >= 0) {
			this.seatsAEvent = seatsAEvent;
		} else {
			throw new DomainException(MSG_ERROR_SEATSAVAILABLE);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + eventId;
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seatsAEvent;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (seatsAEvent != other.seatsAEvent)
			return false;
		return true;
	}
	

	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return o.getName().compareTo(this.name);
	}

}