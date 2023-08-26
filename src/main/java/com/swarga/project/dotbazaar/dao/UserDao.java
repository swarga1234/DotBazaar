package com.swarga.project.dotbazaar.dao;

import com.swarga.project.dotbazaar.entities.User;

public interface UserDao {

	public void addUser(User user);
	public User getUserByUserEmail(String userEmail);
}
