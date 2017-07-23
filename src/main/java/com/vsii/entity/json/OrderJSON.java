package com.vsii.entity.json;

import java.io.Serializable;
import java.util.Date;

public class OrderJSON implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private Date orderDate;
	private String description;
	private int quantity;
	private Date updatedAt;
	private int userId;
	private String statusName;
	private int supplierId;
	
	public OrderJSON() {
		super();
	}

	public OrderJSON(int orderId, Date orderDate, String description, int quantity, Date updatedAt, int userId,
			String statusName, int supplierId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.description = description;
		this.quantity = quantity;
		this.updatedAt = updatedAt;
		this.userId = userId;
		this.statusName = statusName;
		this.supplierId = supplierId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
}
