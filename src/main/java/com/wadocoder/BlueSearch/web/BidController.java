package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.service.PostService;
import com.wadocoder.BlueSearch.service.UserService;

@Controller
public class BidController {
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;

	@GetMapping("/bid/{postId}")
	public String getBid(ModelMap model, @AuthenticationPrincipal User user, @PathVariable Long postId) {
		model.put("currentUser", user);
		model.put("post", postService.findById(postId));
		model.put("otherUser", userService.getUserByPostId(postId));
		return "bid";
	}
}
