package com.vsii.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DetailOrderId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Order order;
	private Food food;
	
	@ManyToOne
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@ManyToOne
	public Food getFood() {
		return food;
	}
	
	public void setFood(Food food) {
		this.food = food;
	}
	
}
