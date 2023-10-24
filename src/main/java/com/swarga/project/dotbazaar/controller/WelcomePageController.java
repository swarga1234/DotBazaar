package com.swarga.project.dotbazaar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swarga.project.dotbazaar.dao.CategoryDao;
import com.swarga.project.dotbazaar.entities.Category;
import com.swarga.project.dotbazaar.entities.User;
import com.swarga.project.dotbazaar.services.CategoryService;
import com.swarga.project.dotbazaar.services.ProductService;

@Controller
public class WelcomePageController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = {"/welcome", "/welcome/category/{categoryId}"})
	public String showWelcomePage(@PathVariable(name = "categoryId",required =false) String categoryId, HttpServletRequest request)
	{
		System.out.println("Hello welcome");
		HttpSession session= request.getSession(false);
		User user=(User) session.getAttribute("user");
		if(user!=null && user.getUserType().equals("Admin"))
		{
			return "redirect:/admin-page";
		}
		else if(user!=null && user.getUserType().equals("Customer"))
		{
			return "redirect:/market-place/category/"+categoryId;
		}
		return "redirect:/";

	}
	@RequestMapping(path = "/admin-page")
	public String showAdminPage(HttpServletRequest request)
	{
		HttpSession session= request.getSession(false);
		if(session==null)
		{
			return "redirect:/";
		}
		User user= (User) session.getAttribute("user");
		if(user==null)
		{
			System.out.println("No Login");
			session.setAttribute("message", "Login Please!!");
			return "redirect:/";
		}
		else if(user.getUserType().equals("Customer"))
		{
			//System.out.println("Hi Customer!!");
			session.setAttribute("message", user.getUserEmail()+" is not Admin!");
			return "redirect:/";
		}
		session.setAttribute("title","Admin Page");
		List<Category> allCategories = this.categoryService.getAllcategories();
		session.setAttribute("categories", allCategories);
		return "admin-page";

	}
	@RequestMapping(path = {"/market-place","/market-place/category/{categoryId}"})
	public String showMarketPLace(@PathVariable(name = "categoryId",required =false) String categoryId, HttpServletRequest request)
	{
		System.out.println(categoryId);
		HttpSession session=request.getSession(false);
		if(session==null) {
			System.out.println("Hi");
			return "redirect:/";

		}
		User user= (User) session.getAttribute("user");
		if(user==null)
		{
			System.out.println("No");
			session.setAttribute("message", "Login Please!!");
			return "redirect:/";
		}
		session.setAttribute("title","Market Place");
		List<Category> allCategories = this.categoryService.getAllcategories();
		session.setAttribute("categories", allCategories);
		session.setAttribute("products", this.productService.getProductsByCategory(categoryId));
		return "market-place";
	}
	@RequestMapping(path = "/logout")
	public String logOut(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.removeAttribute("user");
			session.invalidate();
		}
		
		return "redirect:/";
	}
}
