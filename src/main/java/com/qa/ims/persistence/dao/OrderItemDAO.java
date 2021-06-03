package com.qa.ims.persistence.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");
		return new OrderItem(orderId, itemId, quantity);
	}
	
	
	@Override
	public List<OrderItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	
	@Override
	public OrderItem read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(order_id, item_id, quantity) VALUES (?, ? , ?)");) {
			statement.setLong(1, orderItem.getOrderId());
			statement.setLong(2, orderItem.getItemId());
			statement.setLong(3, orderItem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET order_id = ?, item_id = ? , quantity = ?  WHERE order_id = ?  AND item_id = ?" + 
								";");) {
			
			statement.setLong(1, orderItem.getOrderId());
			statement.setLong(2, orderItem.getItemId());
			statement.setLong(3, orderItem.getQuantity());
			statement.setLong(4, orderItem.getOrderId());
			statement.setLong(5, orderItem.getItemId());
			
			statement.executeUpdate();
			return read(orderItem.getOrderItemId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	













}
