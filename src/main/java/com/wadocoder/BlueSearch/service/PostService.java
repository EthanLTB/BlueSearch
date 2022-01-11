package com.wadocoder.BlueSearch.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;

	public Post createPost(User user, Post post) {
		
		post.setCreatedDate(LocalDateTime.now());
		
		post.setUser(user);
		
		
		return postRepo.save(post);
		
	}

	public List<Post> findAll() {
	List<Post> posts = postRepo.findAllByOrderByPostIdDesc();

	
		return posts;
	}

	public void deleteById(Long postId) {
		postRepo.deleteById(postId);
		
	}
}
