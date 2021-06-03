package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("id");
		Long customerId = resultSet.getLong("costumer_id");
		Date date = resultSet.getDate("date");
		
		return new Order(orderId,customerId, date);
	}
	
	
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
		        .prepareStatement("INSERT INTO orders(costumer_id, date) VALUES (?, ?)");) {
			statement.setLong(1, order.getCustomerId());
			statement.setDate(2, order.getDateOfOrder());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	
		@Override
		public int delete(long id) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
				    statement.setLong(1, id);
				return statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			
		
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement2 = connection.prepareStatement("DELETE FROM order_items WHERE order_id = ?");) {
				    statement2.setLong(1, id);
				return statement2.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return 0;
		
		
		}	
		
   @Override
	public Order update(Order t) {
		// UPDATE is calling UPDATE METHOD from OrderItemDAO !!
		return null;
	}


     public static double getTotalDAO(double orderId) {
    	 double total = 0;
    	 try (Connection connection = DBUtils.getInstance().getConnection();
 				Statement statement = connection.createStatement();
 				ResultSet resultSet = statement.executeQuery("SELECT items.item_price, order_items.quantity FROM order_items\n" + 
 						"INNER JOIN items ON items.id = order_items.item_id;");) {
 			    
 			while (resultSet.next()) {
 				total += modelTotalFromResultSet(resultSet);
 			}
 		
			return total;
 		} catch (SQLException e) {
 			LOGGER.debug(e);
 			LOGGER.error(e.getMessage());
 		}
		return 0;
 		
    	 
   }


     public static double modelTotalFromResultSet(ResultSet resultSet) throws SQLException {
 		Double orderQuantity = resultSet.getDouble("quantity");
 		Double orderPrice = resultSet.getDouble("item_price");
 		
 		Double result = orderQuantity * orderPrice;
 		return result;
 	}





}
