package com.vsii.service;

import java.util.List;

import com.vsii.entity.Food;

public interface IFoodService {
	public List<Food> getAllFoods(int supplierId);
	public Food getFoodById(int foodId, int supplierId);
    public boolean addFood(Food food);
    public int updateFood(Food food);
    public int deleteFood(int foodId);
}
