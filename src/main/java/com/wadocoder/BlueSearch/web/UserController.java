package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public String getProfile(ModelMap model, @AuthenticationPrincipal User user) {
		model.put("user", user);
		
		return "profile";
	}
	
	@GetMapping("/profile/{userId}")
	public String getOtherProfile(@AuthenticationPrincipal User user, @PathVariable Long userId, ModelMap model) {
		model.put("user", user);
		model.put("otherUser", userService.findById(userId));
		
		return "profile";
		
	}

}
