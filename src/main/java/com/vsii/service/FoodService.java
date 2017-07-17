package com.vsii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsii.dao.IFoodDAO;
import com.vsii.entity.Food;

@Service
public class FoodService implements IFoodService {

	@Autowired
	private IFoodDAO foodDAO;
	
	@Override
	public List<Food> getAllFoods() {
		return foodDAO.getAllFoods();
	}

	@Override
	public Food getFoodById(long foodId) {
		Food food = foodDAO.getFoodById(foodId);
		return food;
	}

	@Override
	public boolean addFood(Food food) {
		if (foodDAO.FoodExist(food.getFoodName())) {
            return false;
        } else {
        	foodDAO.addFood(food);
            return true;
        }
	}

	@Override
	public void updateFood(Food food) {
		foodDAO.updateFood(food);
	}

	@Override
	public void deleteFood(int foodId) {
		foodDAO.deleteFood(foodId);
	}
	
}
