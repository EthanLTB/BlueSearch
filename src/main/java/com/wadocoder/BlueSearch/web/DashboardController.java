package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.service.PostService;

@Controller
public class DashboardController {
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String dashboardRedirect() {
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		model.put("user", user);
		model.put("post", new Post());
		model.put("posts", postService.findAll());
		return "dashboard";
	}
	

	

}
