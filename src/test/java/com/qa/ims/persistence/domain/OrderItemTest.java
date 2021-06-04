package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderItemTest {


	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderItem.class).verify();
	}

	@Test
	public void CheckConstructor() {
		assertTrue(new OrderItem(1l,2l,3l,4l) instanceof OrderItem);
	}
	
	
	

	@Test
	public void CheckConstructor2() {
		assertTrue(new OrderItem(1l,2l,3l) instanceof OrderItem);
	}



}
