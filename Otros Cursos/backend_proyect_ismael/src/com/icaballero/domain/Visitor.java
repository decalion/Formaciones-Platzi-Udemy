package com.icaballero.domain;

import com.icaballero.exceptions.DomainException;
import com.icaballero.utils.Validator;

/**
 * POJO for VISITOR CLASS
 * 
 * @author Ismael Caballero
 */
public class Visitor extends People {

	// Longitud Minima UserName
	private final static int MIN_LONG_USERNAME = 6;

	// Longitud Maxima UserName
	private final static int MAX_LONG_USERNAME = 12;

	// Longitud Minima Password
	private final static int MIN_LONG_PASSWORD = 6;

	// Longitud Maxima Password
	private final static int MAX_LONG_PASSWORD = 15;

	// Mensaje Error UserName
	private final static String MSG_ERROR_USERNAME = "Invalid Username";

	// Mensaje Error Password
	private final static String MSG_ERROR_PASSWORD = "Invalid Password";

	// Identificador del visitante
	private int visitorId;

	private String userName;// Nombre de usuario utilizado en el portal web

	private String password; // Contraseña del usuario

	// Booleano que indica si el visitante es administrador o no
	private boolean admin;

	/**
	 * Constructor por defecto, crea un visitante vacio
	 */
	public Visitor() {
	}

	/**
	 * Constructor de copia, crea un objeto Vistor copiando los atributos de
	 * otro
	 */
	public Visitor(Visitor visitor) {
		if (visitor != null) {
			this.visitorId = visitor.getVisitorId();
			this.userName = visitor.getUserName();
			this.password = visitor.getPassword();
			this.admin = visitor.isAdmin();
		}
	}

	/**
	 * Metodo que devuelve el visitor id
	 * 
	 * @return visitorID
	 */
	public int getVisitorId() {
		return visitorId;
	}

	/**
	 * Metodo para guardar el visitorId
	 * 
	 * @param visitorId
	 */
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	/**
	 * Metodo que devuelve el userName
	 * 
	 * @return UserName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Metodo para guardar el userNmae
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {

		if (Validator.validateLongitud(userName, MIN_LONG_USERNAME, MAX_LONG_USERNAME)) {
			this.userName = userName;
		} else {
			throw new DomainException(MSG_ERROR_USERNAME);
		}

	}

	/**
	 * Metodo que devuelve el password
	 * 
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo para guardar el password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		if (Validator.validateLongitud(password, MIN_LONG_PASSWORD, MAX_LONG_PASSWORD)) {
			this.password = password;
		} else {
			throw new DomainException(MSG_ERROR_PASSWORD);
		}

	}

	/**
	 * Metodo que nos devuelve true o false dependiendo de si es es admin o no
	 * 
	 * @return true o false
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Metodo para guardar si es admin o no
	 * 
	 * @param admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + visitorId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		if (admin != other.admin)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (visitorId != other.visitorId)
			return false;
		return true;
	}

}
