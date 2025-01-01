package com.rkfoods.dao;

import java.util.ArrayList;

import com.rkfoods.model.User;

public interface UserDao {
	int addUser(User u);
	ArrayList<User> getAllUsers();
	User getUser(String email);
	int updateUser(User u);
	int deleteUser(String email);

}
