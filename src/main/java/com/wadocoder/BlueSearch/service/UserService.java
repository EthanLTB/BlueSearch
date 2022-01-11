package com.wadocoder.BlueSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Authorities;
import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.repository.AuthoritiesRepository;
import com.wadocoder.BlueSearch.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthoritiesRepository authorityRepo;
	@Autowired
	private UserRepository userRepo;
	
	public void saveUser(User user) {
		Authorities authority = new Authorities();
		authority.setUser(user);
		authority.setAuthority("ROLE_HOMEOWNER");
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepo.save(user);
		authorityRepo.save(authority);
	}

	public Object findById(Long userId) {
		
		return userRepo.findByUserId(userId);
	}

}
