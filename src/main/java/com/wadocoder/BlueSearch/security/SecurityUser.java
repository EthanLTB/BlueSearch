package com.wadocoder.BlueSearch.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.wadocoder.BlueSearch.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = -6181706091746350146L;

	public SecurityUser() {
	}

	public SecurityUser(User user) {
		this.setUserId(user.getUserId());
		this.setAddress(user.getAddress());
		this.setBids(user.getBids());
		this.setComments(user.getComments());
		this.setDescription(user.getDescription());
		this.setEmail(user.getEmail());
		this.setName(user.getName());
		this.setLastName(user.getLastName());
		this.setPhoneNumber(user.getPhoneNumber());
		this.setUsername(user.getUsername());
		this.setPosts(user.getPosts());
		this.setPassword(user.getPassword());
		this.setAuthorities(user.getAuthorities());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
