package com.wadocoder.BlueSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Address;
import com.wadocoder.BlueSearch.domain.Authorities;
import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.repository.AuthoritiesRepository;
import com.wadocoder.BlueSearch.repository.PostRepository;
import com.wadocoder.BlueSearch.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthoritiesRepository authorityRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PostRepository postRepo;
	
	public void createUser(User user) {
		Authorities authority = new Authorities();
		Address address = new Address();
		address.setUser(user);
		address.setUserId(user.getUserId());
		authority.setUser(user);
		
		authority.setAuthority("ROLE_HOMEOWNER");
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setAddress(address);
		user.setPassword(encryptedPassword);
		userRepo.save(user);
		authorityRepo.save(authority);
		if(user.getHasTrade() == null) {
			user.setHasTrade(false);
		}
		else if(user.getHasTrade() == true) {
			Authorities authority2 = new Authorities();
			authority2.setAuthority("ROLE_TRADESPERSON");
			authorityRepo.save(authority2);
		} 
		
	}
	
	public void updateUserProfile(User user) {
	    
		userRepo.save(user);
	}
	
	public User findByUserId(Long userId) {
		return userRepo.findByUserId(userId);
	}

	public User findByIdAndAddressWithPosts(Long userId) {
		
		return userRepo.findByIdAndAddressWithPosts(userId);
	}

	public User getUserByPostId(Long postId) {
		Post post = postRepo.findByPostId(postId);
		User user = userRepo.findByUserId(post.getUser().getUserId());
		return user;
	}





}
