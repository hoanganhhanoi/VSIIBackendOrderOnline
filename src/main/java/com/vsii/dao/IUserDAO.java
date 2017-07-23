package com.vsii.dao;

import java.util.List;

import com.vsii.entity.User;

public interface IUserDAO {
	public List<User> getAllUsers();
	public User getUserById(long userId);
    public User addUser(User user);
    public int updateUser(User user);
    public int deleteUser(long userId);
    public boolean userExist(String userName);
}
