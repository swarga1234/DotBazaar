package com.swarga.project.dotbazaar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swarga.project.dotbazaar.entities.User;
import com.swarga.project.dotbazaar.services.UserService;
@Controller
public class HomePageController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/")
	public String showHomePage(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			User user=(User) session.getAttribute("user");
			System.out.println("hello"+user);
			if(user!=null)
			{
				return "redirect:/market-place";
			}
		}

		return "index";
	}

	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> processSignUp(@ModelAttribute User user, RedirectAttributes redirectAttributes)
	{
		Map<String,String> response= new HashMap<String, String>();
		user.setUserType("Customer");
		System.out.println(user);
		if(user.getUserName()!=null && user.getUserEmail()!=null)
		{
			this.userService.createUser(user);
			response.put("status", "success");
			response.put("message", "Successfully Registered!!");


		}
		else
		{
			response.put("status", "error");

			response.put("message", "Error: Unable to Register the User!");

		}

		return response;
	}
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> processLogin(@RequestParam("userEmail") String userEmail, 
			@RequestParam("userPassword") String userPassword, HttpServletRequest request)
	{
		String errorMessage="Something went Wrong!!";
		Map<String,String> response= new HashMap<String, String>();
		if(userEmail!=null)
		{
			User user = this.userService.getUserByUseremail(userEmail);
			if(user!=null && user.getUserPassword().equals(userPassword))
			{
				HttpSession session= request.getSession(false);
				System.out.println( session.getId());
				session.setAttribute("user", user);
				response.put("status", "success");
			}
			else
			{
				response.put("status", "error");
				errorMessage="Email and Password don't match for "+userEmail;
			}

		}
		response.put("message", errorMessage);
		return response;

	}
}
