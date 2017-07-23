package com.vsii.service;

import java.util.List;

import com.vsii.entity.User;

public interface IUserService {
	 public List<User> getAllUsers();
     public User getUserById(long userId);
     public boolean addUser(User user);
     public int updateUser(User user);
     public int deleteUser(long userId);
}
