package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	
	@Id
    @OneToOne
    @JoinColumn(name="status_id")
	private Status status;
	
	@Id
	@OneToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
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
	
}
