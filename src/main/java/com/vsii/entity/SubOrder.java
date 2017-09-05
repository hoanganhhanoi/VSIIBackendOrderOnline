package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SubOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private int subOrderId;
	private String foodName;
	private Date createdAt;
	private Date updatedAt;
	private int userId;
	private int orderId;

	public SubOrder() {
		super();
	}

	public SubOrder(int subOrderId, String foodName, Date createdAt, Date updatedAt, int user, int order) {
		super();
		this.subOrderId = subOrderId;
		this.foodName = foodName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userId = user;
		this.orderId = order;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int user) {
		this.userId = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int order) {
		this.orderId = order;
	}

}
