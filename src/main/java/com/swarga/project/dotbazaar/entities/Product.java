package com.swarga.project.dotbazaar.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10, name = "product_id")
	private int productId;
	@Column(length = 100, name = "produc_name")
	private String productName;
	@Column(length = 3000, name = "product_desc")
	private String productDesc;
	@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_photos", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "photos")
	private List<String> productPhotos;
	@Column(length = 10, name = "product_price")
	private double productPrice;
	@Column(length = 10, name = "product_discount")
	private int productDiscount;
	@Column(length = 10, name = "product_qty")
	private int productQuantity;
	@ManyToOne
	private Category  category;
	@ManyToOne
	private User user;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public List<String> getProductPhotos() {
		return productPhotos;
	}
	public void setProductPhotos(List<String> productPhotos) {
		this.productPhotos = productPhotos;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", "
				+ (productName != null ? "productName=" + productName + ", " : "")
				+ (productDesc != null ? "productDesc=" + productDesc + ", " : "")
				+ (productPhotos != null ? "productPhotos=" + productPhotos + ", " : "") + "productPrice="
				+ productPrice + ", productDiscount=" + productDiscount + ", productQuantity=" + productQuantity + ", "
				+ (category != null ? "category=" + category + ", " : "") + (user != null ? "user=" + user : "") + "]";
	}
	
	
	
	
}
