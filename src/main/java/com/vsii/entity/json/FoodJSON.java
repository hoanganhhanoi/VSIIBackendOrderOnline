package com.vsii.entity.json;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FoodJSON implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int foodId;
	private String foodName;
	private String description;
	private String newPrice;
	private String oldPrice;
	private Date createdAt;
	private Date updatedAt;
	private int supplierId;
	
	public FoodJSON() {
		super();
	}

	public FoodJSON(int food_id, String food_name, String description, String new_price, String old_price,
			Date created_at, Date updated_at, int supplierId) {
		super();
		this.foodId = food_id;
		this.foodName = food_name;
		this.description = description;
		this.newPrice = new_price;
		this.oldPrice = old_price;
		this.createdAt = created_at;
		this.updatedAt = updated_at;
		this.supplierId = supplierId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int food_id) {
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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplier(int supplierId) {
		this.supplierId = supplierId;
	}
}
