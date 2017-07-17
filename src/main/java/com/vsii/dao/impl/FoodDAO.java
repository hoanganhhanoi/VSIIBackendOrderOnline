package com.vsii.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsii.dao.IFoodDAO;
import com.vsii.entity.Food;

@Transactional
@Repository
public class FoodDAO implements IFoodDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getAllFoods() {
		String sql = "FROM Food ORDER BY food_id";
		return (List<Food>) entityManager.createQuery(sql).getResultList();
	}

	@Override
	public Food getFoodById(long foodId) {
		return entityManager.find(Food.class, foodId);
	}

	@Override
	public void addFood(Food food) {
		entityManager.persist(food);
	}

	@Override
	public void updateFood(Food food) {
		System.out.println("============================================================");
		System.out.println(food.getFoodName());
		Food oldFood = getFoodById(food.getFoodId());
		oldFood.setFoodName(food.getFoodName());
		oldFood.setDescription(food.getDescription());
		oldFood.setOldPrice(food.getOldPrice());
		oldFood.setNewPrice(food.getNewPrice());
		oldFood.setUpdatedAt(food.getUpdatedAt());
		entityManager.flush();
	}

	@Override
	public void deleteFood(int foodId) {
		entityManager.remove(getFoodById(foodId));
	}

	@Override
	public boolean FoodExist(String foodName) {
		String sql = "FROM Food WHERE food_name = ?";
		int count = entityManager.createQuery(sql).setParameter(1, foodName).getResultList().size();
		return count > 0 ? true : false; 
	}
	
}
