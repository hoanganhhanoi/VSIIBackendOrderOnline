package com.vsii.service;

import java.util.List;

import com.vsii.entity.Food;

public interface IFoodService {
	public List<Food> getAllFoods();
	public Food getFoodById(long foodId);
    public boolean addFood(Food food);
    public void updateFood(Food food);
    public void deleteFood(int foodId);
}
