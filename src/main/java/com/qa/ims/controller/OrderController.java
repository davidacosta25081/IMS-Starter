package com.qa.ims.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import com.qa.ims.persistence.dao.OrderDAO;
	import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

	public class OrderController implements CrudController<Order> {

		public static final Logger LOGGER = LogManager.getLogger();

		private OrderDAO orderDAO;
		private Utils utils;

		public OrderController(OrderDAO orderDAO, Utils utils) {
			super();
			this.orderDAO = orderDAO;
			this.utils = utils;
		}

		/**
		 * Reads all order to the logger
		 */
		@Override
		public List<Order> readAll() {
			List<Order> orders = orderDAO.readAll();
			for (Order order : orders) {
				LOGGER.info(order.toString());
			}
			return orders;
		}
		
		/**
		 * Creates a order by taking in user input
		 */
		@Override
		public Order create() {
			String addMore;
			LOGGER.info("Please enter a customer ID");
			Long customerId = utils.getLong();
			Date dateOfOrder = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			Order order = orderDAO.create(new Order(customerId,dateOfOrder));
			
			do {
				LOGGER.info("Please enter a item ID");
				Long itemId = utils.getLong();
				LOGGER.info("Please enter quantity of item");
				Long quantity = utils.getLong();
				
				//orderDAO.create(order.getOrderId(),itemId,quantity);
				LOGGER.info("Add more items? .... YES or NOT ");
				addMore = utils.getString();
			}while(addMore.toLowerCase().equals("YES"));
			LOGGER.info("Order successfully created");
			
			return order;
		}

		/**
		 * Updates an existing order by taking in user input
		 */
		//@Override
//		public Order update() {
//			LOGGER.info("please enter orderId of order you'd like to update");
//			Long orderId = utils.getLong();
//			LOGGER.info("Please enter itemId of item you'd like to update");
//			Long itemId = utils.getLong();
//			LOGGER.info("please enter the new quantity");
//			Long quantity = utils.getLong();
//			LOGGER.info("order updated");
//			return orderDAO.update(new OrderItem(orderId, itemId, quantity));
//			
//			}
		
		@Override
		
		public int delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long id = utils.getLong();
			orderDAO.delete(id);
			return orderDAO.delete(id);
		}

		@Override
		public Order update() {
			// TODO Auto-generated method stub
			return null;
		}

		
	}























