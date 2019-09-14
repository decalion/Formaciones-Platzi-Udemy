package com.icaballero.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que maneja las validaciones de los formatos de los datos de la
 * aplicación
 * 
 * @author Ismael Caballero
 * 
 */
public class Validator {

	/**
	 * Valida la longitud de un string
	 * 
	 * @param name
	 * @param longmin
	 * @param longmax
	 * @return true o false
	 */
	public static boolean validateLongitud(String name, int longmin, int longmax) {

		if (name != null && name.length() >= longmin && name.length() <= longmax) {

			return true;

		}

		return false;
	}

	/**
	 * Valida una expresion regular
	 * 
	 * @param expre
	 * @param name
	 * @return true o false
	 */
	public static boolean validateExpresion(String expre, String name) {
		Pattern pat = Pattern.compile(expre);
		Matcher match = pat.matcher(name);

		if (match.matches()) {
			return true;
		}

		return false;
	}

	/**
	 * Valida el DNI
	 * 
	 * @param dni
	 * @param exp
	 * @return true o false
	 */
	public static boolean validateDni(String dni, String exp) {

		if (validateExpresion(exp, dni)) {
			if (dni.length() == 10) {

				String number = dni.substring(0, 8);
				char letter = (char) dni.toUpperCase().charAt(9);

				if (validateDniLetter(number, letter)) {
					return true;
				} else {
					return false;
				}

			} else {
				if (dni.length() == 9) {
					String number = dni.substring(0, 8);
					char letter = (char) dni.toUpperCase().charAt(8);

					if (validateDniLetter(number, letter)) {
						return true;
					} else {
						return false;
					}
				}
			}

		}

		return false;
	}

	/**
	 * Valida la lettra del DNI
	 * 
	 * @param number
	 * @param l
	 * @return true o false
	 */
	private static boolean validateDniLetter(String number, char l) {
		char letters[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };

		int numberDni = Integer.parseInt(number);

		int result = numberDni % 23;

		return letters[result] == l;
	}

}
