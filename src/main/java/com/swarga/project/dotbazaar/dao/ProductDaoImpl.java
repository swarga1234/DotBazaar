package com.swarga.project.dotbazaar.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.swarga.project.dotbazaar.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void addProduct(Product product) {
		this.hibernateTemplate.save(product);
	}

}
