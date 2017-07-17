package com.vsii.service;

import java.util.List;

import com.vsii.entity.User;

public interface IUserService {
	 public List<User> getAllUsers();
     public User getUserById(long userId);
     public boolean addUser(User user);
     public void updateUser(User user);
     public void deleteUser(long userId);
}
