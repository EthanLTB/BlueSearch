package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.service.BidService;
import com.wadocoder.BlueSearch.service.CommentService;
import com.wadocoder.BlueSearch.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private BidService bidService;
	
	@GetMapping("/profile")
	public String getProfile(ModelMap model, @AuthenticationPrincipal User user) {
		model.put("user", user);
		
		return "profile";
	}
	
	@GetMapping("/profile/{userId}")
	public String getOtherProfile(@AuthenticationPrincipal User user, @PathVariable Long userId, ModelMap model) {
	    User otherUser = userService.findByIdAndAddressWithPosts(userId);
	    model.put("address", otherUser.getAddress());
	    model.put("posts", otherUser.getPosts());
	    model.put("comments", commentService.findAllByUserId(userId));
	    model.put("bids", bidService.findAllByUserId(userId));
		model.put("user", user);
		model.put("otherUser", otherUser);
		
		return "profile";
		
	}
	
	@PostMapping("/profile/{userId}")
	public String updateProfile(@PathVariable Long userId, User otherUser) {
		
		otherUser.getAddress().setUserId(userId);
		otherUser.getAddress().setUser(otherUser);
		userService.updateUserProfile(otherUser);
		
		return"redirect:/profile/{userId}";
	}

}
