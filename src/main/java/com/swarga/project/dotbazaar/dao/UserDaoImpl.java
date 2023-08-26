package com.swarga.project.dotbazaar.dao;

import javax.persistence.TypedQuery;
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
	@Transactional
	public User getUserByUserEmail(String userEmail) {
		
		TypedQuery<User> query = hibernateTemplate.getSessionFactory().getCurrentSession()
                .createQuery("FROM User u WHERE u.userEmail = :useremail", User.class);
        query.setParameter("useremail", userEmail);
        User user = query.getSingleResult();
		return user;

	}

}
