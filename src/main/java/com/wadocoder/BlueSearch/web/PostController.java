package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.service.CommentService;
import com.wadocoder.BlueSearch.service.PostService;
import com.wadocoder.BlueSearch.service.UserService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/post/{postId}")
	public String getOnePost(ModelMap model, @PathVariable Long postId, @AuthenticationPrincipal User user) {
		model.put("post", postService.findById(postId));
		model.put("currentUser", user);
		model.put("postUser", userService.getUserByPostId(postId));
		model.put("comments", commentService.findAllByPost(postId));
		return "post";
	}

	@PostMapping("/dashboard/{postId}/delete")
	public String deletePost(@PathVariable Long postId) {
		
		postService.deleteById(postId);
		
		return "redirect:/dashboard";
	}
	@PostMapping("/createPost")
	public String createPost(@AuthenticationPrincipal User user, Post post) {
		System.out.println("Creating post");
		 postService.createPost(user, post);
		 return "redirect:/dashboard";
	}
}
