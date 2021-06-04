package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	@Test
	public void CheckConstructor() {
		assertTrue(new Item("Pepsi", "Soda" , 20.4) instanceof Item);
	}
	
	@Test
	public void CheckConstructor2() {
		assertTrue(new Item(1l,"Keyboard","Magic", 30.54) instanceof Item);
	}



	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}



}
