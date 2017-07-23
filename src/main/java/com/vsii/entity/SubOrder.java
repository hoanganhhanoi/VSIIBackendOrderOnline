package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SubOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private int subOrderId;
	private String foodName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date updatedAt;
	private User user;
	private Order order;

	public SubOrder() {
		super();
	}

	public SubOrder(int subOrderId, String foodName, Date createdAt, Date updatedAt, User user, Order order) {
		super();
		this.subOrderId = subOrderId;
		this.foodName = foodName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.order = order;
	}

	public int getSubOrderId() {
		return subOrderId;
	}

	public void setSubOrderId(int subOrderId) {
		this.subOrderId = subOrderId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
