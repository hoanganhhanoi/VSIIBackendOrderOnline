package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Supplier implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int supplierId;
	private String supplierName;
	private String address;
	private Date createdAt;
	private Date updatedAt;
	
	public Supplier() {
		super();
	}

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
	
}
