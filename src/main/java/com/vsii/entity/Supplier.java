package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Entity
@Table(name="Supplier")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Supplier implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="supplier_name")
	private String supplierName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;

	public Supplier() {
		super();
	}
	
	// mappedBy la thuoc tinh ben Order
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "supplier", fetch = FetchType.LAZY, optional = false)
	private Order order;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "supplier_food", 
	joinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id"), 
	inverseJoinColumns = @JoinColumn(name = "food_id", referencedColumnName = "food_id"))
	private List<Food> foods;

	public Supplier(int supplier_id, String name, String address, Date created_at, Date updated_at) {
		super();
		this.supplierId = supplier_id;
		this.supplierName = name;
		this.address = address;
		this.createdAt = created_at;
		this.updatedAt = updated_at;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplier_name) {
		this.supplierName = supplier_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
