package com.qa.ims.persistence.domain;

import java.sql.Date;

public class Order {
	
	private Long orderId;
	private Long customerId;
	private Date dateOfOrder; 
	
	public Order(Long orderId, Long customerId, Date dateOfOrder) {
		this.setDateOfOrder(dateOfOrder);
		this.setOrderId(orderId);
	    this.setDateOfOrder(dateOfOrder);
	}
	
	public Order(Long customerId, Date dateOfOrder) {
		this.setCustomerId(customerId);
	    this.setDateOfOrder(dateOfOrder);
	}
	
	
	
    public String toString() {
		return "order id: " + orderId + " customer id: " + customerId + "  Date Ordered: " + dateOfOrder
				+ "\n";
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	
    
	
	
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : Long.hashCode(orderId));
		result = prime * result + ((customerId == null) ? 0 : Long.hashCode(customerId));
		result = prime * result + ((dateOfOrder == null) ? 0 : dateOfOrder.hashCode());
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
		Order other = (Order) obj;
		// Compare OrderId
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId)) 
			return false;
		// Compare CustomerId
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId())) 
			return false;
		// Compare DateOfOrder
		if (getDateOfOrder() == null) {
			if (other.getDateOfOrder() != null)
				return false;
		} else if (!getDateOfOrder().equals(other.getDateOfOrder()))
			return false;
		return true;
	}

}
