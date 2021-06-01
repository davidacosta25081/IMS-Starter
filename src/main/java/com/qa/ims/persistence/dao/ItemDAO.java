package com.qa.ims.persistence.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

        public static final Logger LOGGER = LogManager.getLogger();

		@Override
		public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("id");
			String itemName = resultSet.getString("item_name");
			String itemDescription = resultSet.getString("item_description");
			Double itemPrice = resultSet.getDouble("item_price");
			return new Item(id, itemName, itemDescription,itemPrice);
		}

		/**
		 * Reads all customers from the database
		 * 
		 * @return A list of customers
		 */
		@Override
		public List<Item> readAll() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
				List<Item> items = new ArrayList<>();
				while (resultSet.next()) {
					items.add(modelFromResultSet(resultSet));
				}
				return items;
			} catch (SQLException e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Item readLatest() {
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























}
