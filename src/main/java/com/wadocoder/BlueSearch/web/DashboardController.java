package com.wadocoder.BlueSearch.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.dto.PostDto;
import com.wadocoder.BlueSearch.service.PostService;

@Controller
public class DashboardController {
	@Autowired
	private PostService postService;

	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		model.put("post", new Post());
		return "dashboard";
	}
	
	@PostMapping("/createPost")
	public String createPost(@AuthenticationPrincipal User user, Post post) {
		System.out.println("Creating post");
		 postService.createPost(user, post);
		 return "redirect:/dashboard";
	}
	
	@PostMapping("/getPosts")
	@ResponseBody
	public List<PostDto> getPosts(){
		return postService.findAll();
		
	}
}
