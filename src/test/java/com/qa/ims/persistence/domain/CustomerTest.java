package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	@Test
	public void CheckConstructor() {
		assertTrue(new Customer("David", "Acosta") instanceof Customer);
	}
	
	
	

	@Test
	public void CheckConstructor2() {
		assertTrue(new Customer(1l,"Lionel","Messi") instanceof Customer);
	}


    
}
