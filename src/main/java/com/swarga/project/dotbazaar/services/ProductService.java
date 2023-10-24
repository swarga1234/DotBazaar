package com.swarga.project.dotbazaar.services;

import java.util.List;

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
	
	public List<Product> getAllProducts(){
		return this.productDao.getAllProducts();
	}
	
	public List<Product> getProductsByCategory(String categoryId){
		
		if((categoryId!=null && !categoryId.equals("null")) && !categoryId.trim().equals("all"))
		{
			System.out.println(categoryId);
			int cid=Integer.parseInt(categoryId);
			return this.productDao.getProductsByCategory(cid);
		}
		else
		{
			return getAllProducts();
		}
	}
}
