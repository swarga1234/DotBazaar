package com.swarga.project.dotbazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swarga.project.dotbazaar.entities.User;

@Controller
public class WelcomePageController {

	@RequestMapping(path = "/welcome")
	public String showWelcomePage(HttpServletRequest request)
	{
		HttpSession session= request.getSession(false);
		User user=(User) session.getAttribute("user");
		if(user!=null && user.getUserType().equals("Admin"))
		{
			return "redirect:/admin-page";
		}
		else if(user!=null && user.getUserType().equals("Customer"))
		{
			return "redirect:/market-place";
		}
		return "redirect:/";

	}
	@RequestMapping(path = "/admin-page")
	public String showAdminPage(HttpServletRequest request)
	{
		HttpSession session= request.getSession(false);
		User user= (User) session.getAttribute("user");
		if(user==null)
		{
			System.out.println("No Login");
			session.setAttribute("message", "Login Please!!");
			return "redirect:/";
		}
		else if(user.getUserType().equals("Customer"))
		{
			System.out.println("Hi Customer!!");
			session.setAttribute("message", user.getUserEmail()+" is not Admin!");
			return "redirect:/";
		}
		return "admin-page";

	}
	@RequestMapping(path = "/market-place")
	public String showMarketPLace(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null) {
			System.out.println("Hi");
			return "redirect:/";

		}
		User user= (User) session.getAttribute("user");
		if(user==null)
		{
			session.setAttribute("message", "Login Please!!");
			return "redirect:/";
		}
		return "market-place";
	}
}
