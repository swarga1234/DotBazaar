package com.swarga.project.dotbazaar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swarga.project.dotbazaar.dao.ProductDao;
import com.swarga.project.dotbazaar.entities.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public void saveProduct(Product product)
	{
		this.productDao.addProduct(product);
	}
}
