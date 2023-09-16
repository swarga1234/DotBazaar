package com.swarga.project.dotbazaar.dao;

import java.util.List;

import com.swarga.project.dotbazaar.entities.Category;

public interface CategoryDao {

	public void addCategory(Category category);
	public List<Category> getAllCategories();
	public Category getCategoryById(int categoryId);
}
