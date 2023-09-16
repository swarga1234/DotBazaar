package com.swarga.project.dotbazaar.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.swarga.project.dotbazaar.entities.Category;
import com.swarga.project.dotbazaar.entities.Product;
import com.swarga.project.dotbazaar.entities.User;
import com.swarga.project.dotbazaar.services.CategoryService;
import com.swarga.project.dotbazaar.services.ProductService;
import com.swarga.project.dotbazaar.util.FileUtilities;

@Controller
public class DataOperationController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping(path="/add-category", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> processAddCategory(@ModelAttribute Category category, HttpServletRequest request)
	{
		Map<String,String> response= new HashMap<String, String>();

		HttpSession session= request.getSession(false);
		User user=(User) session.getAttribute("user");
		if(user!=null)
		{
			if(null!=category && (category.getCategoryName()!=null || !category.getCategoryName().isEmpty()))
			{
				this.categoryService.addCategory(category);
				response.put("status", "success");
				session.setAttribute("message", category.getCategoryName()+" is added!!");

			}
			else
			{
				response.put("status", "error");

				response.put("message", "Error: Unable to add Category!!");
			}
		}

		return response;
	}
	@RequestMapping(path = "/add-product", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> processAddProduct( @RequestParam("productName")String productName,
			@RequestParam("productDesc") String productDesc,
			@RequestParam("productPrice") double productPrice,
			@RequestParam("productDiscount") int productDiscount,
			@RequestParam("productQuantity") int productQuantity,
			@RequestParam("productPhotoFiles") List<MultipartFile> productPhotosList,
			@RequestParam("categoryId") int categoryId,
			HttpServletRequest request)
	{
		Map<String,String> response= new HashMap<String, String>();
		HttpSession session= request.getSession(false);
		User user=(User) session.getAttribute("user");
		Product product=new Product();
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setProductPrice(productPrice);
		product.setProductDiscount(productDiscount);
		product.setProductQuantity(productQuantity);
		Category category= this.categoryService.getCategoryById(categoryId);
		//category.getProductList().
		System.out.println(category);
		product.setCategory(category);
		product.setUser(user);
		String directoryPath=session.getServletContext().getRealPath("/")+"resources"+File.separator+"Products";
		System.out.println(directoryPath);
		List<String> productPhotos= new ArrayList<String>();
		if(null!=productPhotosList && !productPhotosList.isEmpty())
		{
			for(MultipartFile photo:productPhotosList)
			{
				productPhotos.add(photo.getOriginalFilename());
				
				FileUtilities.saveFile(directoryPath, photo);
			}
		}

		product.setProductPhotos(productPhotos);
		if(user!=null)
		{
			this.productService.saveProduct(product);
			
			response.put("status", "success");
			session.setAttribute("message", product.getProductName()+" is added!!");


		}
		else
		{
			response.put("status", "error");

			response.put("message", "Error: Unable to add Product!!");
		}
		return response;

	}
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	@ResponseBody
	public Map<String,String>  exceptionHandlerConstraintViolationException(DataIntegrityViolationException e) {
		Map<String,String> response= new HashMap<String, String>();
		response.put("status", "error");
		response.put("message", "Error: This category already exists!!");
		return response;

	}

}
