package com.qa.ims.persistence.domain;

public class OrderItem {

	private Long orderItemId;
    private Long orderId;
    private Long itemId;
    private Long quantity;
    
    public OrderItem() {
    }

    public OrderItem(Long orderId, Long itemId, Long quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.setQuantity(quantity);
    }

    public OrderItem(Long orderItemId, Long orderId, Long itemId, Long quantity) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.setQuantity(quantity);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

    
   
    @Override 
	public int hashCode() {
		final int prime = 5;
		int result = 1;
		result = prime * result + ((orderItemId == null) ? 0 : Long.hashCode(orderItemId));
		result = prime * result + ((orderId == null) ? 0 : Long.hashCode(orderId));
		result = prime * result + ((itemId == null) ? 0 : Long.hashCode(itemId));
		return result;
	}
	
    public String toString() {
		return "orderItem id: " + orderItemId + " order id: " + orderId + " item id: " + itemId
				+ "\n";
	}
    
    
   
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (getOrderItemId() == null) {
			if (other.getOrderItemId() != null) 
				return false;
		} else if (!orderItemId.equals(other.getOrderItemId()))
			return false;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!orderId.equals(other.getOrderId()))
				return false;
		if (getItemId() == null) {
			if (other.getItemId() != null) 
				return false;
		} else if (!itemId.equals(other.getItemId()))
			return false;
		return true;
	
	
	
	}

	


}






