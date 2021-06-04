package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
	
	
	@Test
	public void testCreate() {
		final String name = "Headphones";
		final String description = "Sony MX3";
		final Double price = 34.43;
		final Item item = new Item(name,description,price);

		
		Mockito.when(utils.getString()).thenReturn(name);
		Mockito.when(utils.getString()).thenReturn(description);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(dao.create(item)).thenReturn(item);
		assertEquals(item, this.controller.create());

		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(item);
	
	}
	
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("jordan", "harrison", 100.3));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	
	@Test
	public void testUpdate() {
		
		final String name = "Headphones";
		final String description = "Sony MX3";
		final Double price = 34.43;
		
		
		Item updated = new Item(name, description, price);

		Mockito.when(utils.getString()).thenReturn(name);
		Mockito.when(utils.getString()).thenReturn(description);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(dao.create(updated)).thenReturn(updated);
		
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	
	@Test
	public void DeleteTest() {
		final long DeleteID = 1L;

		Mockito.when(utils.getLong()).thenReturn(DeleteID);
		Mockito.when(dao.delete(DeleteID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(DeleteID);
	}
	
	

	
	
}