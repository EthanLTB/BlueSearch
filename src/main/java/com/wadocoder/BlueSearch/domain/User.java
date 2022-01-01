package com.wadocoder.BlueSearch.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userId;
private String username;
private String password;
private String name;
private String lastName;
private String email;
private String phoneNumber;
private String status;
private String description;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private Address address;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Post> posts = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Comment> comments = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Bid> bids = new ArrayList<>();

@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
private List<Authority> authorities = new ArrayList<>();


public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}


public List<Post> getPosts() {
	return posts;
}
public void setPosts(List<Post> posts) {
	this.posts = posts;
}


public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}


public List<Bid> getBids() {
	return bids;
}
public void setBids(List<Bid> bids) {
	this.bids = bids;
}
@Override
public int hashCode() {
	return Objects.hash(userId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(userId, other.userId);
}
@Override
public String toString() {
	return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
			+ ", lastName=" + lastName + ", status=" + status + ", description=" + description + ", address=" + address
			+ ", posts=" + posts + ", comments=" + comments + ", bids=" + bids + "]";
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
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
public void setAuthorities(List<Authority> authorities) {
	this.authorities = authorities;
}

}
