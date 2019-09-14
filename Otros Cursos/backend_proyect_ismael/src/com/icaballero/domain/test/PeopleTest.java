package com.icaballero.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.domain.People;
import com.icaballero.exceptions.DomainException;

/**
 * Testers de los Metodos de la Clase People
 * 
 * @author Ismael Caballero
 *
 */
public class PeopleTest {

	private People people;

	@Before
	public void setUp() throws Exception {
		people = new People();
	}

	@After
	public void tearDown() throws Exception {
		people = null;
	}

	/**
	 * Testemos el constructor
	 */
	@Test
	public void testPeople() {
		People p = new People();
	}

	/**
	 * Testeamos el Constructor copia, copia correcta y no null
	 */
	@Test
	public void testPeoplePeople() {
		people.setFirstName("Ismael");
		people.setLastName("Caballero");
		people.setAddres("Carrer Vallirana");
		people.setDni("45858750Q");
		people.setEmail("icaballerohernandez@gmail.com");
		people.setPhoneNumber("98 787 656 70");

		People p = new People(people);

		assertEquals(people, p);

		// People pp = new People(null);
	}

	/**
	 * Testemos un FirstName Correctp
	 */
	@Test
	public void testSetFirstName() {
		people.setFirstName("Ismael");
		assertEquals("Ismael", people.getFirstName());

	}

	@Test(expected = DomainException.class)
	public void testSetFirstNameLongitus() {
		people.setFirstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		people.setFirstName("");
		people.setFirstName(null);

	}

	/**
	 * Testemos un LastName Correcto
	 */
	@Test
	public void testSetLastName() {
		people.setLastName("Caballero");
		assertEquals("Caballero", people.getLastName());
	}

	@Test(expected = DomainException.class)
	public void testSetLastNameLongitus() {
		people.setLastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		people.setLastName("");
		people.setLastName(null);

	}

	/**
	 * Testeamos un Email Correcto
	 */
	@Test
	public void testSetEmail() {
		people.setEmail("icaballerohernandez@gmail.com");
		assertEquals("icaballerohernandez@gmail.com", people.getEmail());
	}

	@Test(expected = DomainException.class)
	public void testSetEmailFormat() {
		people.setEmail("@aaa@aaa.com");
		people.setEmail("aaa.com@email");
		people.setEmail("aaa@.a");
		people.setEmail("aaa.@aaa.com");
		people.setEmail("aaa@aa.a");

	}

	/**
	 * Testeamos un numero Correcto
	 */
	@Test
	public void testSetPhoneNumber() {
		people.setPhoneNumber("98 789 76 56 78");
		assertEquals("98 789 76 56 78", people.getPhoneNumber());
	}

	/**
	 * Testemos un PhoneNumber de Longitud Incorrecta
	 */
	@Test(expected = DomainException.class)
	public void testSetPhoneNumberLongitud() {
		people.setPhoneNumber("12345678");
		people.setPhoneNumber("1234568789123456789123");
		people.setPhoneNumber(null);

	}

	/**
	 * Testemos un PhoneNumber de Formato Incorrecto
	 */
	@Test(expected = DomainException.class)
	public void testSetPhoneNumberFormat() {
		people.setPhoneNumber("90 A7u 897 hte");

	}

	/**
	 * Testeamos una Adress de longitud incorrecta
	 */
	@Test(expected = DomainException.class)
	public void testSetAddressLongitud() {
		people.setAddres("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

	}

	/**
	 * Testeamos una Addres Correcta
	 */
	@Test
	public void testSetAddres() {
		people.setAddres("Carrer Vallirana");
		assertEquals("Carrer Vallirana", people.getAddres());
	}

	/**
	 * Testeamos un DNI correcto con - y sin -
	 */
	@Test
	public void testSetDni() {
		people.setDni("45858750Q");
		assertEquals("45858750Q", people.getDni());
		people.setDni("45858750-Q");
		assertEquals("45858750-Q", people.getDni());
	}

	/**
	 * Teastemos una letra incorrecta del DNI con - y sin -
	 */
	@Test(expected = DomainException.class)
	public void testSetDniLetter() {
		// people.setDni("45858750Z");
		people.setDni("45858750-Z");
	}

	/**
	 * Testemos DNI de Formato Incorrecto
	 */
	@Test(expected = DomainException.class)
	public void testSetDniFormat() {
		people.setDni("45858750ZZ");
		people.setDni("458587509");
		people.setDni("Z45858750");

	}

}
