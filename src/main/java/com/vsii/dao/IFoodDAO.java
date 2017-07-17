package com.vsii.dao;

import java.util.List;

import com.vsii.entity.Food;

public interface IFoodDAO {
	public List<Food> getAllFoods();
	public Food getFoodById(long foodId);
    public void addFood(Food food);
    public void updateFood(Food food);
    public void deleteFood(int foodId);
    public boolean FoodExist(String foodName);
}
