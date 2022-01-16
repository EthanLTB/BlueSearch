package com.wadocoder.BlueSearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wadocoder.BlueSearch.dto.CommentDto;
import com.wadocoder.BlueSearch.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService; 


	@PostMapping("/createComment")
	@ResponseBody
	public String createComment(@RequestBody CommentDto comment) {
		
		commentService.createComment(comment);
		
		return "redirect:@{/post/{postId}(postId=comment.postId)}";
	}
	
	@PostMapping("/post/{postId}/comment/{commentId}/delete")
	public String deletePost( @PathVariable Long commentId, @PathVariable Long postId ) {
		String redirectUrl = "/post/" + postId;
		commentService.deleteById(commentId);
		
		return "redirect:" + redirectUrl;
		
		
		
		
	}
}
