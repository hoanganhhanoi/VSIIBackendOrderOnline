package com.vsii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsii.dao.IUserDAO;
import com.vsii.entity.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public User getUserById(long userId) {
		User user = userDAO.getUserById(userId);
		return user;
	}

	@Override
	public synchronized boolean addUser(User user) {
		if (userDAO.userExist(user.getUserName())) {
            return false;
        } else {
        	userDAO.addUser(user);
            return true;
        }
	}

	@Override
	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public int deleteUser(long userId) {
		return userDAO.deleteUser(userId);
	}
	
	
}
