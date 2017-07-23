package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int status_id;
	private String status_name;
	private Date created_at;
	private Date updated_at;
	private Order order;
	
	public Status() {
		super();
	}

	public Status(int status_id, String status_name, Date created_at, Date updated_at) {
		super();
		this.status_id = status_id;
		this.status_name = status_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
