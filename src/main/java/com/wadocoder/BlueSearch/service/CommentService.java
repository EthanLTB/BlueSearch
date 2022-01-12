package com.wadocoder.BlueSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Comment;
import com.wadocoder.BlueSearch.repository.CommentRepository;
import com.wadocoder.BlueSearch.repository.UserRepository;

@Service
public class CommentService {
	@Autowired
private CommentRepository commentRepo;
	@Autowired
	private UserRepository userRepo;
	
	
	public List<Comment> findAllByUserId(Long userId) {
	
		return commentRepo.findAllByUser(userRepo.findById(userId));
	}
	

}
