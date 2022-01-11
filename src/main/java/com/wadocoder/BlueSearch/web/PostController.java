package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wadocoder.BlueSearch.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@PostMapping("/deletePost/{postId}")
	public String deletePost(@PathVariable Long postId) {
		
		postService.deleteById(postId);
		
		return "redirect:/dashboard";
	}
}
