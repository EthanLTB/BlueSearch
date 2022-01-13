package com.wadocoder.BlueSearch.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Comment;
import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.dto.CommentDto;
import com.wadocoder.BlueSearch.repository.CommentRepository;
import com.wadocoder.BlueSearch.repository.PostRepository;
import com.wadocoder.BlueSearch.repository.UserRepository;

@Service
public class CommentService {
	@Autowired
private CommentRepository commentRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PostRepository postRepo;
	
	
	public List<Comment> findAllByUserId(Long userId) {
	
		return commentRepo.findAllByUser(userRepo.findById(userId));
	}


	public void createComment(CommentDto comment) {
		Comment newComment = new Comment();
		newComment.setCommentDetails(comment.getCommentDetails());
		newComment.setUser(userRepo.findByUserId(comment.getUserId()));
		newComment.setPost(postRepo.findByPostId(comment.getPostId()));
		newComment.setCreatedDate(LocalDateTime.now());
		
		commentRepo.save(newComment);
	}


	public List<Comment> findAllByPost(Long postId) {
		Post post = postRepo.findByPostId(postId);
		return commentRepo.findAllByPost(post);
	}
	

}
