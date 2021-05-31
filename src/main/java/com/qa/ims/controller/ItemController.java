package com.qa.ims.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;





public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	
	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates an Item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter item's name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item's description");
		String itemDescription = utils.getString();
		LOGGER.info("Please enter item's price");
		Double itemPrice = utils.getDouble();
		Item item = itemDAO.create(new Item(itemName, itemDescription,itemPrice));
		LOGGER.info("Item created");
		return item;
	}

	
	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter item's name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item's new description");
		String itemDescription = utils.getString();
		LOGGER.info("Please enter item's price");
		Double itemPrice = utils.getDouble();
		Item item = itemDAO.update(new Item(id, itemName, itemDescription,itemPrice));
		LOGGER.info("Item Updated");
		return item;
	}
    
	/**
	 * Deletes an existing item by the item's id
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}



}











