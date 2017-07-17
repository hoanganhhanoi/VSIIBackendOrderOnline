package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id")
	private long supplier_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_at")
	private Date created_at;
	
	@Column(name="updated_at")
	private Date updated_at;

	public Supplier() {
		super();
	}

	public Supplier(int supplier_id, String name, String address, Date created_at, Date updated_at) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.address = address;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}
