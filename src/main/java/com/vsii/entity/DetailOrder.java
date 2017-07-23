package com.vsii.entity;

public class DetailOrder implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Food food;
	private Order order;
	private int quantity;

	public DetailOrder() {
		super();
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
