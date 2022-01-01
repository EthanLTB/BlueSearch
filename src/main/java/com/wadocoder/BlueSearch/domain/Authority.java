package com.wadocoder.BlueSearch.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = 7712292587159620L;
	private Long id;
	private String authority;
	private User user;

	public Authority() {

	}

	public Authority(String authority) {
		this.authority = authority;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne()
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public List<GrantedAuthority> getAuthority() {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new Authority("ROLE_HOMEOWNER"));
		return roles;
	}




}
