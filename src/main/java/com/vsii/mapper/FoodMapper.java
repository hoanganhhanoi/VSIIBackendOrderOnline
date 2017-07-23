package com.vsii.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vsii.entity.Food;
import com.vsii.entity.Supplier;

public class FoodMapper implements RowMapper<Food> {

	@Override
	public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
		Food food = new Food();
		Supplier supplier = new Supplier();
		food.setFoodId(rs.getInt("food_id"));
		food.setFoodName(rs.getString("food_name"));
		food.setDescription(rs.getString("description"));
		food.setNewPrice(rs.getString("new_price"));
		food.setOldPrice(rs.getString("old_price"));
		food.setCreatedAt(rs.getDate("created_at"));
		food.setUpdatedAt(rs.getDate("updated_at"));
		supplier.setSupplierId(rs.getInt("supplier_id"));
		food.setSupplier(supplier);
		
		return food;
	}
	
}
