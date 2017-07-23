package com.vsii.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsii.dao.IFoodDAO;
import com.vsii.entity.Food;
import com.vsii.mapper.FoodMapper;

@Transactional
@Repository
public class FoodDAO implements IFoodDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final String FETCH_FOOD = "SELECT food.* FROM food, supplier WHERE food.supplier_id = supplier.supplier_id AND supplier.supplier_id = ?";
	private final String FETCH_FOOD_BY_ID = "SELECT food.* FROM food, supplier WHERE food.supplier_id = supplier.supplier_id AND supplier.supplier_id = ? AND food_id = ?";
	private final String INSERT_FOOD = "INSERT INTO food(food_name, description, new_price, old_price, created_at, updated_at, supplier_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE_FOOD = "UPDATE food SET food_name = ?, description = ?, new_price = ?, old_price = ?, created_at = ?, updated_at = ?, supplier_id = ? WHERE food_id = ?";
	private final String DELETE_FOOD = "DELETE FROM food WHERE food_id = ?";
	private final String FETCH_FOOD_BY_NAME = "SELECT food.* FROM food, supplier WHERE food.supplier_id = supplier.supplier_id AND supplier.supplier_id = ? AND food_name = ?";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getAllFoods(int supplierId) {
		return (List<Food>) jdbcTemplate.query(FETCH_FOOD, new Object[] { supplierId },  new FoodMapper());
	}

	@Override
	public Food getFoodById(int foodId, int supplierId) {
		return jdbcTemplate.queryForObject(FETCH_FOOD_BY_ID, new Object[] { supplierId, foodId }, new FoodMapper());
	}

	@Override
	public Food addFood(Food food) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_FOOD, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, food.getFoodName());
				ps.setString(2, food.getDescription());
				ps.setString(3, food.getNewPrice());
				ps.setString(4, food.getOldPrice());
				ps.setDate(5, (java.sql.Date) food.getCreatedAt());
				ps.setDate(6, (java.sql.Date) food.getUpdatedAt());
				ps.setLong(7, food.getSupplier().getSupplierId());
				return ps;
			}
		}, holder);
		
		int newFoodId = holder.getKey().intValue();
		food.setFoodId(newFoodId);
		return food;
	}

	@Override
	public int updateFood(Food food) {
		return jdbcTemplate.update(UPDATE_FOOD, new Object[] { food.getFoodName(), food.getDescription(), food.getNewPrice(), food.getOldPrice(), food.getCreatedAt(), food.getUpdatedAt(), food.getSupplier().getSupplierId(), food.getFoodId() });
	}

	@Override
	public int deleteFood(int foodId) {
		return jdbcTemplate.update(DELETE_FOOD, new Object[] { foodId });
	}

	@Override
	public boolean FoodExist(String foodName, int supplierId) {
		Food food = jdbcTemplate.queryForObject(FETCH_FOOD_BY_NAME, new Object[] { supplierId, foodName }, new FoodMapper());
		if(food.getFoodName().equals(foodName)) {
			return true;
		}
		return false;
	}
	
}
