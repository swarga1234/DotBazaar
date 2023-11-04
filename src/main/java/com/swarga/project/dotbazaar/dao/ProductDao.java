package com.swarga.project.dotbazaar.dao;

import java.util.List;

import com.swarga.project.dotbazaar.entities.Product;

public interface ProductDao {

	public void addProduct(Product product);
	public Long getAllProductsCount();
	public Long getProductsByCategoryCount(int categoryId);
	public List<Product> getProductsByCategoryAsPage(int categoryId, int pageNo, int pageSize);
	public List<Product> getAllProductsAsPage(int pageNo, int pageSize);

}
