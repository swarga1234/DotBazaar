package com.swarga.project.dotbazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swarga.project.dotbazaar.entities.User;
import com.swarga.project.dotbazaar.services.UserService;
@Controller
public class HomePageController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/")
	public String showHomePage()
	{
		return "index";
	}		
//	@RequestMapping(path = "/registration", method = RequestMethod.POST)
//	public RedirectView registerUser(@ModelAttribute User user, HttpServletRequest request)
//	{
//		user.setUserType("Customer");
//		this.userService.createUser(user);
//		RedirectView redirectView= new RedirectView();
//		String url=request.getContextPath()+"/";
//		redirectView.setUrl(url);
//		return redirectView;
//	}
	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public String processSignUp(@ModelAttribute User user, RedirectAttributes redirectAttributes)
	{
		user.setUserType("Customer");
		System.out.println(user);
		if(user.getUserName()!=null && user.getUserEmail()!=null)
		{
			this.userService.createUser(user);
			redirectAttributes.addFlashAttribute("success", "Registration Successfull!");
		}
		else
		{
			redirectAttributes.addFlashAttribute("error", "Error: Unable to Register the User!");
		}
		//String url=request.getContextPath()+"/";
		return "redirect:/";	}
}
