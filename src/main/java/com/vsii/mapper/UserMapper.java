package com.vsii.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vsii.entity.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setImage(rs.getString("image"));
		user.setCreatedAt(rs.getDate("created_at"));
		user.setUpdatedAt(rs.getDate("updated_at"));
	
		return user;
	}

}
