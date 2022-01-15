package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.dto.Trade;
import com.wadocoder.BlueSearch.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "login";
	}

	
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		model.put("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String createUser(User user ) {
		userService.createUser(user);
		
		return "redirect:/login";
	}
}
