package com.swarga.project.dotbazaar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swarga.project.dotbazaar.dao.UserDao;
import com.swarga.project.dotbazaar.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	public void createUser(User user)
	{
		this.userDao.addUser(user);
	}
}
