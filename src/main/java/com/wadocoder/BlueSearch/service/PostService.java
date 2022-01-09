package com.wadocoder.BlueSearch.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.dto.PostDto;
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

	public List<PostDto> findAll() {
	List<Post> posts = postRepo.findAll();
	List<PostDto> newPosts = new ArrayList<>();
	for(Post post : posts) {
		PostDto newPost = new PostDto();
		newPost.setCreatedDate(post.getCreatedDate());
		newPost.setJobDescription(post.getJobDescription());
		newPost.setPostId(post.getPostId());
		newPost.setUserId(post.getUser().getUserId());
		newPosts.add(newPost);
		
	}
	
		return newPosts;
	}
}
