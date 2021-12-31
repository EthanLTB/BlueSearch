package com.wadocoder.BlueSearch.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
private Long userId;
private String username;
private String password;
private String name;
private String lastName;
private String email;
private String phoneNumber;
private String status;
private String description;
private Address address;
private List<Post> posts;
private List<Comment> comments;
private List<Bid> bids;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
@OneToOne(mappedBy = "user",
cascade = CascadeType.ALL,
orphanRemoval = true)
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
public List<Post> getPosts() {
	return posts;
}
public void setPosts(List<Post> posts) {
	this.posts = posts;
}

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
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

}
