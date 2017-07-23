package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int statusId;
	private String statusName;
	private Date createdAt;
	private Date updatedAt;
	private Order order;
	
	public Status() {
		super();
	}

	public Status(int status_id, String status_name, Date created_at, Date updated_at) {
		super();
		this.statusId = status_id;
		this.statusName = status_name;
		this.createdAt = created_at;
		this.updatedAt = updated_at;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int status_id) {
		this.statusId = status_id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String status_name) {
		this.statusName = status_name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date created_at) {
		this.createdAt = created_at;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updatedAt = updated_at;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
