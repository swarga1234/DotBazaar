package com.swarga.project.dotbazaar.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.swarga.project.dotbazaar.entities.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void addCategory(Category category) {
		this.hibernateTemplate.saveOrUpdate(category);	
	}

	public List<Category> getAllCategories() {

		List<Category> categoryList = this.hibernateTemplate.loadAll(Category.class);
		return categoryList;
	}

	@Transactional
	public Category getCategoryById(int categoryId) {
		return this.hibernateTemplate.get(Category.class, categoryId);

	}

}
