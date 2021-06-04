package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long orderId = 1L;
		final Long customerId = 2L; 
		final Date date = Date.valueOf("1980-04-09");
		final Order created = new Order(orderId, customerId, date);
		
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(utils.getLong()).thenReturn(customerId);
		//Mockito.when(utils.getDouble()).thenReturn(date);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		final Date date = Date.valueOf("1980-04-09");
		orders.add(new Order(1L, 2L,date));
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		assertEquals(orders, controller.readAll());
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testDelete() {
		final long Id = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(Id);
		Mockito.when(dao.delete(Id)).thenReturn(1);
		assertEquals(Id, this.controller.delete());
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(Id);
	}
	
	@Test
	public void testUpdateDetails() {
		Date date = Date.valueOf("1980-04-09");
		Order updated = new Order(1L, 1L, date);
		
		Mockito.when(utils.getLong()).thenReturn(updated.getOrderId());
		Mockito.when(utils.getLong()).thenReturn(updated.getCustomerId());
		//Mockito.when(utils.getDate()).thenReturn(updated.getDateOfOrder());
		Mockito.when(dao.update(updated)).thenReturn(updated);
		
		//assertEquals(updated, controller.update(updated.getOrderId()));
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		//Mockito.verify(utils, Mockito.times(1)).getTime();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
}