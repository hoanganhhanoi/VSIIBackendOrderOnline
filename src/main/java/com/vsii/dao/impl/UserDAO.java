package com.vsii.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsii.dao.IUserDAO;
import com.vsii.entity.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String sql="FROM User ORDER BY user_id";
		return (List<User>) entityManager.createQuery(sql).getResultList();
	}

	@Override
	public User getUserById(long userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		User oldUser = getUserById(user.getUserId());
		oldUser.setUserName(user.getUserName());
		oldUser.setPassword(user.getPassword());
		oldUser.setImage(user.getImage());
		oldUser.setUpdatedAt(user.getUpdatedAt());
		entityManager.flush();
	}

	@Override
	public void deleteUser(long userId) {
		entityManager.remove(getUserById(userId));
	}

	@Override
	public boolean userExist(String userName) {
		String sql = "FROM User WHERE user_name = ?";
		int count = entityManager.createQuery(sql).setParameter(1, userName).getResultList().size();
		return count > 0 ? true : false;
	}
	
}
