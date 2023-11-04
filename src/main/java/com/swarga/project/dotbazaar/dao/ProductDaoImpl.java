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


	public Long getAllProductsCount() {
		
		String query="select COUNT(*) from Product as p";
		Query<Long> createQuery = this.hibernateTemplate.getSessionFactory().openSession().createQuery(query, Long.class);
		return createQuery.uniqueResult();
	}
	
	@Transactional
	public Long getProductsByCategoryCount(int categoryId)
	{
		System.out.println("categoryID: "+categoryId);
		String query="select COUNT(*) from Product as p where p.category.categoryId=: categoryId";
		Query<Long> createQuery = this.hibernateTemplate.getSessionFactory().openSession().createQuery(query, Long.class);
		createQuery.setParameter("categoryId", categoryId);
		return createQuery.uniqueResult();
		
	}

	public List<Product> getProductsByCategoryAsPage(int categoryId, int pageNo, int pageSize)
	{
		String query="from Product as p where p.category.categoryId=: categoryId";
		Query<Product> createQuery = this.hibernateTemplate.getSessionFactory().openSession().createQuery(query, Product.class);
		createQuery.setParameter("categoryId", categoryId);
		int firstIndex=(pageNo-1)*pageSize;
		createQuery.setFirstResult(firstIndex);
		createQuery.setMaxResults(pageSize);
		return createQuery.list();
	}
	
	public List<Product> getAllProductsAsPage(int pageNo, int pageSize)
	{
		String query="from Product as p";
		Query<Product> createQuery = this.hibernateTemplate.getSessionFactory().openSession().createQuery(query, Product.class);
		//createQuery.setParameter("categoryId", categoryId);
		int firstIndex=(pageNo-1)*pageSize;
		createQuery.setFirstResult(firstIndex);
		createQuery.setMaxResults(pageSize);
		return createQuery.list();
	}
}
