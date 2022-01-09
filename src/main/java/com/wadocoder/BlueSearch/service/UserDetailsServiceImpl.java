package com.wadocoder.BlueSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.User;
import com.wadocoder.BlueSearch.repository.UserRepository;
import com.wadocoder.BlueSearch.security.SecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Username and/or Password does not exist");
		}
		return new SecurityUser(user);
	}

}
