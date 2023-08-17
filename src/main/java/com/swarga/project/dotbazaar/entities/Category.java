package com.swarga.project.dotbazaar.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_details")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10, name = "category_Id")
	private int categoryId;
	@Column(length = 100, name = "category_name")
	private String categoryName;
	@Column(length = 100, name = "category_desc")
	private String categoryDescription;
	@OneToMany(mappedBy = "category")
	private List<Product>productList= new ArrayList<Product>();
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", "
				+ (categoryName != null ? "categoryName=" + categoryName + ", " : "")
				+ (categoryDescription != null ? "categoryDescription=" + categoryDescription + ", " : "")
				+ (productList != null ? "productList=" + productList : "") + "]";
	}
	
	
	
}
