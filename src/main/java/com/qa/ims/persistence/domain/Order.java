package com.qa.ims.persistence.domain;

import java.sql.Date;

public class Order {
	
	private Long orderId;
	private Long customerId;
	private Date dateOfOrder; 
	
	public Order(Long orderId, Long customerId, Date dateOfOrder) {
		this(customerId, dateOfOrder);
		this.setOrderId(orderId);
	    this.setDateOfOrder(dateOfOrder);
	}
	
	public Order(Long customerId, Date dateOfOrder) {
		this.setCustomerId(customerId);
	    this.setDateOfOrder(dateOfOrder);
	}
	
	
	
	@Override
	public String toString() {
		return String.format("ID: %d CustomerID: %d ", this.getOrderId(), this.getCustomerId());
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
	
}
