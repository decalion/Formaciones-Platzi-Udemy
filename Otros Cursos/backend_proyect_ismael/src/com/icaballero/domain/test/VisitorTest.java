package com.icaballero.domain.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.domain.Visitor;
import com.icaballero.exceptions.DomainException;

/**
 * Test de los Metodos de la clase Visitor
 * 
 * @author Ismael Caballero
 *
 */
public class VisitorTest {

	private Visitor visitor;

	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
	}

	@After
	public void tearDown() throws Exception {
		visitor = null;
	}

	/**
	 * Test del constructor
	 */
	@Test
	public void testVisitor() {
		Visitor v = new Visitor();
	}

	/**
	 * Test del constructor copia, copia correcta y no null
	 */
	@Test
	public void testVisitorVisitor() {
		visitor.setVisitorId(1);
		visitor.setUserName("alumno");
		visitor.setPassword("alumno");
		visitor.setAdmin(true);

		Visitor v = new Visitor(visitor);

		assertEquals(visitor, v);

		Visitor vv = new Visitor(null);
	}

	/**
	 * Test visitor id correcto
	 */
	@Test
	public void testSetVisitorId() {
		visitor.setVisitorId(1);
		assertEquals(1, visitor.getVisitorId());
	}

	/**
	 * Test username coorrecto
	 */
	@Test
	public void testSetUserName() {
		visitor.setUserName("alumno");
		assertEquals("alumno", visitor.getUserName());
	}

	/**
	 * Test longitud username incorrecta y no null
	 */
	@Test(expected = DomainException.class)
	public void testSetUserNameLongitud() {
		visitor.setUserName("aaaaa");
		visitor.setUserName("aaaaaaaaaaaaa");
		visitor.setUserName(null);
	}

	/**
	 * test password correcto
	 */
	@Test
	public void testSetPassword() {
		visitor.setPassword("alumno");
		assertEquals("alumno", visitor.getPassword());
	}

	/**
	 * Test longitud password incorrecta y no null
	 */
	@Test(expected = DomainException.class)
	public void testSetPasswordLongitud() {
		visitor.setPassword("aaaaa");
		visitor.setPassword("aaaaaaaaaaaaaaaaa");
		visitor.setPassword(null);
	}

	/**
	 * test setadmin correcto
	 */
	@Test
	public void testSetAdmin() {
		visitor.setAdmin(true);
		assertEquals(true, visitor.isAdmin());
	}

}
