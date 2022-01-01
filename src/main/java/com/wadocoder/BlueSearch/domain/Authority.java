package com.wadocoder.BlueSearch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = 7712292587159620L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String authority;
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id")
	private User user;

	public Authority() {

	}

	public Authority(String authority) {
		this.authority = authority;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
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
	public String getAuthority() {
		
		return this.authority;
	}

	



}
