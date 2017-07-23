package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private int orderId;
	private Date orderDate;
	private String description;
	private int quantity;
	private Date updatedAt;
	private User user;
	private Status status;
	private Supplier supplier;
	private Set<SubOrder> subOrders;
	private Set<DetailOrder> detailOrders;

	public Order() {
		super();
	}

	public Order(int order_id, Date order_date, String description, int quantity, Date updated_at) {
		super();
		this.orderId = order_id;
		this.orderDate = order_date;
		this.description = description;
		this.quantity = quantity;
		this.updatedAt = updated_at;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set<SubOrder> getSubOrders() {
		return subOrders;
	}

	public void setSubOrders(Set<SubOrder> subOrders) {
		this.subOrders = subOrders;
	}

	public Set<DetailOrder> getDetailOrders() {
		return detailOrders;
	}

	public void setDetailOrders(Set<DetailOrder> detailOrders) {
		this.detailOrders = detailOrders;
	}

}
