package com.vsii.dao;

import java.util.List;

import com.vsii.entity.Food;

public interface IFoodDAO {
	public List<Food> getAllFoods(int supplierId);
	public Food getFoodById(int foodId, int supplierId);
    public Food addFood(Food food);
    public int updateFood(Food food);
    public int deleteFood(int foodId);
    public boolean FoodExist(String foodName, int supplierId);
}
