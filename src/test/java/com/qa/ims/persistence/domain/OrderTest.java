package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	Date sqlDate = Date.valueOf("1980-04-09");
	
	@Test
	public void CheckConstructor() {
		assertTrue(new Order(1l, sqlDate) instanceof Order);
	}
	
	@Test
	public void CheckConstructor2() {
		assertTrue(new Order(1l,2l, sqlDate) instanceof Order);
	}



	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}



}