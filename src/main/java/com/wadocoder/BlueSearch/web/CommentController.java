package com.wadocoder.BlueSearch.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;

@Controller
public class CommentController {

	@PostMapping("/createComment")
	public String createComment(@AuthenticationPrincipal User user, CommentDto comment) {
		
		return "redirect:/dashboard";
	}
}
