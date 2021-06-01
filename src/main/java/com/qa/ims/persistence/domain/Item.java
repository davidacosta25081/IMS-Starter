package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String itemName;
	private String itemDescription;
	private Double itemPrice;
	
	public Item(String name, String description, Double price) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}
	
	public Item(Long id, String name, String description, Double price) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return itemName;
	}

	public void setName(String name) {
		this.itemName = name;
	}

	public String getDescription() {
		return itemDescription;
	}

	public void setDescription(String description) {
		this.itemDescription = description;
	}
	
	public Double getPrice() {
		return itemPrice;
	}
	
	public void setPrice(Double cost) {
		this.itemPrice = cost;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "Item's name" + itemName + "Item's description" + itemDescription + "Item's price" + itemPrice;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().contentEquals(other.getName())) {
			return false;
		}
		if (id == null) {
			if (other.id != null) 
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.getDescription()))
			return false;
		if (itemPrice == null) {
			if (other.itemPrice != null)
				return false;
		} else if (!itemPrice.equals(other.getPrice())) {
			return false;
		}
		return true;
	}
}