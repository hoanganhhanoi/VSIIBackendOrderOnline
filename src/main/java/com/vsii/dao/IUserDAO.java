package com.vsii.dao;

import java.util.List;

import com.vsii.entity.User;

public interface IUserDAO {
	public List<User> getAllUsers();
	public User getUserById(long userId);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(long userId);
    public boolean userExist(String userName);
}
