package com.swarga.project.dotbazaar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swarga.project.dotbazaar.dao.CategoryDao;
import com.swarga.project.dotbazaar.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	
	public void addCategory(Category category)
	{
		this.categoryDao.addCategory(category);
	}
	public List<Category> getAllcategories()
	{
		List<Category> categories = this.categoryDao.getAllCategories();
		return categories;
	}
	public Category getCategoryById(int categoryId)
	{
		Category category = this.categoryDao.getCategoryById(categoryId);
		return category;
	}
}
