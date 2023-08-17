package com.swarga.project.dotbazaar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swarga.project.dotbazaar.entities.User;
import com.swarga.project.dotbazaar.services.UserService;
@Controller
public class SignUpController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/popup")
	public String showHomePage()
	{
		return "popup";
	}

	//	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	//	@ResponseBody
	//	public Map<String, String> processSignUp(@ModelAttribute User user)
	//	{
	//		Map<String, String> response = new HashMap<String, String>();
	//		user.setUserType("Customer");
	//		System.out.println(user);
	//		if(user.getUserName()!=null)
	//		{
	//			this.userService.createUser(user);
	//			response.put("status", "success");
	//		}
	//		else
	//		{
	//			response.put("status", "error");
	//		}
	//        
	//        return response;
	//	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String processSignUp(@ModelAttribute User user, RedirectAttributes redirectAttributes)
	{
		user.setUserType("Customer");
		System.out.println(user);
		if(user.getUserName()!=null)
		{
			this.userService.createUser(user);
			redirectAttributes.addFlashAttribute("message", "success");
		}
		else
		{
			redirectAttributes.addFlashAttribute("message", "error");
		}
		return "redirect:/popup";
	}
}
