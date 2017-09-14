package com.vsii.entity.json;

import java.io.Serializable;

public class SubOrderJSON implements Serializable {
    private static final long serialVersionUID = 1L;

    private int quantity;
    private int userId;
    private int orderId;
    private int foodId;

    public SubOrderJSON() {
    }

    public SubOrderJSON(int quantity, int userId, int orderId, int foodId) {
        this.quantity = quantity;
        this.userId = userId;
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
