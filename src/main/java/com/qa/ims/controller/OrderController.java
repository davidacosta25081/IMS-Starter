package com.qa.ims.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

	public class OrderController implements CrudController<Order> {

		public static final Logger LOGGER = LogManager.getLogger();

		private OrderDAO orderDAO;
		private OrderItemDAO orderItemDAO;
		private static Utils utils;

		
		public OrderController(OrderDAO orderDAO,OrderItemDAO oriDAO, Utils utils) {
			super();
			this.orderDAO = orderDAO;
			this.orderItemDAO = oriDAO;
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
			
			LOGGER.info("\nTo CREATE a new Shopping cart (ORDER) type: CREATE \nTo ADD to an existing one type ADD");
            String response = utils.getString();
			
            if (response.toLowerCase().equals("create")) {
		      LOGGER.info("Please enter a customer ID");
			  Long customerId = utils.getLong();
			  Date dateOfOrder = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			  Order order = orderDAO.create(new Order(customerId,dateOfOrder));
			  return order;
            }else{
//			
			  
			  
			  String addMore;
			do {
				
				LOGGER.info("ADD items to Shopping Cart (ORDER) number : ");
				Long orderId = utils.getLong();
				LOGGER.info("Please enter item's id");
				Long itemId = utils.getLong();
				LOGGER.info("Please enter quantity of item");
				Long quantity = utils.getLong();
				
				orderItemDAO.create(new OrderItem(orderId,itemId,quantity));
				
				LOGGER.info("Add more items? .... YES or NOT ");
				addMore = utils.getString();
			}while(addMore.toLowerCase().equals("yes"));
			   LOGGER.info("Order successfully created");
			   return null;
			 }
			}

		/**
		 * Updates an existing order by taking in user input
		 * @return 
		 */
		@Override
		public Order update() {
			LOGGER.info("please enter orderId of order you'd like to UPDATE");
			Long orderId = utils.getLong();
			LOGGER.info("Please enter itemId of item you'd like to UPDATE");
			Long itemId = utils.getLong();
			LOGGER.info("please enter the new quantity");
			Long quantity = utils.getLong();
			LOGGER.info("order updated");
			orderItemDAO.update(new OrderItem(orderId, itemId, quantity));
			LOGGER.info("Order successfully UPDATED");
			return null;
			
		}
		
		@Override
		
		public int delete() {
			LOGGER.info("Please enter the ID of the order you would like to DELETE");
			Long id = utils.getLong();
			orderDAO.delete(id);
			return orderDAO.delete(id);
		}

		

		
	   public static double getTotal() {
		   
		   LOGGER.info("Enter ORDER ID to get TOTAL :\n");
		   Double orderId = utils.getDouble();
		   Double total = OrderDAO.getTotalDAO(orderId);
		   LOGGER.info("___________________\n\nORDER TOTAL : " + total + 
				   "\n___________________");
	   
		   
	      return total;
	   
	   }
	   
	
	
	
	}























