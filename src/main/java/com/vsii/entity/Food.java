package com.vsii.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Entity
@Table(name="Food")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Food implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="food_id")
	private long foodId;
	
	@NotNull
	@Column(name="food_name")
	private String foodName;
	
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="new_price")
	private String newPrice;
	
	@JsonIgnore
	@Column(name="old_price")
	private String oldPrice;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;

	
	public Food() {
		super();
	}

	public Food(int food_id, String food_name, String description, String new_price, String old_price,
			Date created_at, Date updated_at) {
		super();
		this.foodId = food_id;
		this.foodName = food_name;
		this.description = description;
		this.newPrice = new_price;
		this.oldPrice = old_price;
		this.createdAt = created_at;
		this.updatedAt = updated_at;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long food_id) {
		this.foodId = food_id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String food_name) {
		this.foodName = food_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(String new_price) {
		this.newPrice = new_price;
	}

	public String getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(String old_price) {
		this.oldPrice = old_price;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date created_at) {
		this.createdAt = created_at;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updatedAt = updated_at;
	}

}
