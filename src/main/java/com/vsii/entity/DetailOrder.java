package com.vsii.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "detail_order")
@AssociationOverrides({
        @AssociationOverride(name = "pk.order", 
            joinColumns = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "pk.food", 
            joinColumns = @JoinColumn(name = "food_id")) })
public class DetailOrder implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private DetailOrderId pk = new DetailOrderId();
	
	@Column(name="quantity")
	private int quantity;

	public DetailOrder() {
		super();
	}
	
	@EmbeddedId
	public DetailOrderId getPk() {
		return pk;
	}

	public void setPk(DetailOrderId pk) {
		this.pk = pk;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Transient
	public Order getOrder() {
		return getPk().getOrder();
	}

	public void setOrder(Order order) {
		getPk().setOrder(order);
	}

	@Transient
	public Food getFood() {
		return getPk().getFood();
	}

	public void setFood(Food food) {
		getPk().setFood(food);
	}
	
}
