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
	public List<Food> getAllFoods(int supplierId) {
		return foodDAO.getAllFoods(supplierId);
	}

	@Override
	public Food getFoodById(int foodId, int supplierId) {
		Food food = foodDAO.getFoodById(foodId, supplierId);
		return food;
	}

	@Override
	public boolean addFood(Food food) {
		if (foodDAO.FoodExist(food.getFoodName(), food.getSupplier().getSupplierId())) {
            return false;
        } else {
        	foodDAO.addFood(food);
            return true;
        }
	}

	@Override
	public int updateFood(Food food) {
		return foodDAO.updateFood(food);
	}

	@Override
	public int deleteFood(int foodId) {
		return foodDAO.deleteFood(foodId);
	}
	
}
