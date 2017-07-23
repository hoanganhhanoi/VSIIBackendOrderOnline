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

import com.vsii.dao.IUserDAO;
import com.vsii.entity.User;
import com.vsii.mapper.UserMapper;

@Transactional
@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String FETCH_USER = "SELECT * FROM user ORDER BY user_name ASC";
	private final String FETCH_USER_BY_ID = "SELECT * FROM user WHERE user_id = ?";
	private final String INSERT_USER = "INSERT INTO user(user_name, password, image, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
	private final String UPDATE_USER = "UPDATE user SET user_name = ?, password = ?, image = ?, created_at = ?, updated_at = ? WHERE user_id = ?";
	private final String DELETE_USER = "DELETE FROM user WHERE user_id = ?";
	private final String FETCH_USER_BY_NAME = "SELECT * FROM user WHERE user_name = ?";
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return (List<User>) jdbcTemplate.query(FETCH_USER, new UserMapper());
	}

	@Override
	public User getUserById(long userId) {
		return jdbcTemplate.queryForObject(FETCH_USER_BY_ID, new Object[] { userId }, new UserMapper());
	}

	@Override
	public User addUser(User user) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getImage());
				ps.setDate(4, (java.sql.Date) user.getCreatedAt());
				ps.setDate(5, (java.sql.Date) user.getUpdatedAt());
				return ps;
			}
		}, holder);
		
		int newUserId = holder.getKey().intValue();
		user.setUserId(newUserId);
		return user;
	}

	@Override
	public int updateUser(User user) {
		int row = jdbcTemplate.update(UPDATE_USER, new Object[]
		        { user.getUserName(), user.getPassword(), user.getImage(), user.getCreatedAt(), user.getUpdatedAt(), user.getUserId() });
		return row;
	}

	@Override
	public int deleteUser(long userId) {
		int row = jdbcTemplate.update(DELETE_USER, new Object[] {userId});
		return row;
	}

	@Override
	public boolean userExist(String userName) {
		User user = jdbcTemplate.queryForObject(FETCH_USER_BY_NAME, new Object[] { userName }, new UserMapper());
		if(user.getUserName().equals(userName)) {
			return true;
		}
		return false;
	}
	
}
