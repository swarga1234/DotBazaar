package com.swarga.project.dotbazaar.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
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


	public List<Product> getAllProducts() {
		return this.hibernateTemplate.loadAll(Product.class);
		
	}
	
	@Transactional
	public List<Product> getProductsByCategory(int categoryId)
	{
		System.out.println("categoryID: "+categoryId);
		String query="from Product as p where p.category.categoryId=: categoryId";
		Query<Product> createQuery = this.hibernateTemplate.getSessionFactory().openSession().createQuery(query, Product.class);
		createQuery.setParameter("categoryId", categoryId);
		return createQuery.list();
		
	}

}
