package com.icaballero.domain;

import com.icaballero.exceptions.DomainException;
import com.icaballero.utils.Validator;

/**
 * POJO for PEOPLE class which is PARENT CLASS for Visitor
 * 
 * @author Ismael Caballero
 */
public class People {

	// Longitud Minima FirstName
	private final static int MIN_LONG_FIRSTNAME = 1;

	// Longitud Maxima FirstName
	private final static int MAX_LONG_FIRSTNAME = 30;

	// Longitud Minima LastName
	private final static int MIN_LONG_LASTNAME = 1;

	// Longitud Minima PhonrNumber
	private final static int MIN_LONG_PHONENUMBER = 10;

	// Longitud Maxima PhoneNumber
	private final static int MAX_LONG_PHONENUMBER = 20;

	// Longitud Maxima lastName
	private final static int MAX_LONG_LASTNAME = 30;

	// Longitud Maxima Adress
	private final static int MAX_LONG_ADRESS = 30;

	// EXP REGULAR PhoneNumber
	private final static String EXP_PHONE_NUMBER = "\\+?[\\d*\\s*]*";

	// Exp Regular DNI
	private final static String EXP_DNI = "(\\d{8})([-]?)([A-Za-z]{1})";

	// Exp Regular Email
	private final static String EXP_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// Mensaje de Error FirstName
	private final static String MSG_ERROR_FIRSTNAME = "Invalid Firstname";

	// Mensaje de Erro LastName
	private final static String MSG_ERROR_LASTNAME = "Invalid Lastname";

	// Mensaje de Error DNI
	private final static String MSG_ERROR_DNI = "Invalid DNI";

	// Mensaje de Erro Email
	private final static String MSG_ERROR_EMAIL = "Invalid Email";

	// Mensaje de Error PhoneNumber
	private final static String MSG_ERROR_PHONENAME = "Invalid Phonename";

	// Mensaje de Error Adresss
	private final static String MSG_ERROR_ADDRESS = "Invalid Address";

	private String firstName; // Nombre

	private String lastName; // Apellido

	private String dni; // dni

	private String email; // Correo electrónico

	private String phoneNumber; // Número de teléfono

	private String address;// Dirección

	/**
	 * Constructor por defecto de una persona, crea una persona vacia
	 */
	public People() {
	}

	/**
	 * Constructor de copia, crea un objeto People copiando los atributos de
	 * otro
	 * 
	 * @param people
	 *            Persona que se va a copiar
	 */
	public People(People people) {
		if (people != null) {
			this.firstName = people.getFirstName();
			this.lastName = people.getLastName();
			this.dni = people.getDni();
			this.email = people.getEmail();
			this.phoneNumber = people.getPhoneNumber();
			this.address = people.getAddres();
		}
	}

	/**
	 * Devuelve el First Name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Metodo para Guardar el FirstName
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {

		if (Validator.validateLongitud(firstName, MIN_LONG_FIRSTNAME, MAX_LONG_FIRSTNAME)) {
			this.firstName = firstName;
		} else {
			throw new DomainException(MSG_ERROR_FIRSTNAME);
		}

	}

	/**
	 * Devuelve el LastName
	 * 
	 * @return LastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Metodo para guardar el lastName
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {

		if (Validator.validateLongitud(lastName, MIN_LONG_LASTNAME, MAX_LONG_LASTNAME)) {
			this.lastName = lastName;
		} else {
			throw new DomainException(MSG_ERROR_LASTNAME);
		}

	}

	/**
	 * Metodo que devuelve el DNI
	 * 
	 * @return DNI
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo para guardar el dni
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		if (Validator.validateDni(dni, EXP_DNI)) {
			this.dni = dni;
		} else {
			throw new DomainException(MSG_ERROR_DNI);
		}

	}

	/**
	 * metodo que devuelve el email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * metodo para guardar el email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		if (Validator.validateExpresion(EXP_EMAIL, email)) {
			this.email = email;
		} else {
			throw new DomainException(MSG_ERROR_EMAIL);
		}

	}

	/**
	 * Metodo que devuelve el phonenumber
	 * 
	 * @return phonenumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Metodo para guardar el phonenumber
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (Validator.validateExpresion(EXP_PHONE_NUMBER, phoneNumber)
				&& Validator.validateLongitud(phoneNumber, MIN_LONG_PHONENUMBER, MAX_LONG_PHONENUMBER)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new DomainException(MSG_ERROR_PHONENAME);
		}
	}

	/**
	 * Metodo que devuelve la address
	 * 
	 * @return address
	 */
	public String getAddres() {
		return address;
	}

	/**
	 * Metodo para guardar la Adress
	 * 
	 * @param addres
	 */
	public void setAddres(String addres) {

		if (addres.length() < MAX_LONG_ADRESS) {
			this.address = addres;
		} else {
			throw new DomainException(MSG_ERROR_ADDRESS);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		People other = (People) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

}
