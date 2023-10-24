package com.swarga.project.dotbazaar.dao;

import java.util.List;

import com.swarga.project.dotbazaar.entities.Product;

public interface ProductDao {

	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public List<Product> getProductsByCategory(int categoryId);
}
