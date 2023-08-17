package com.swarga.project.dotbazaar.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.swarga.project.dotbazaar.entities.User;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public void addUser(User user) {
		
		this.hibernateTemplate.save(user);
	}

}
