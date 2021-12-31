package com.wadocoder.BlueSearch.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bid {
private Long bidId;
private Double price;
private String message;
private Post post;
private User user;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
public Long getBidId() {
	return bidId;
}
public void setBidId(Long bidId) {
	this.bidId = bidId;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@ManyToOne
@JoinColumn(name="post_id")
public Post getPost() {
	return post;
}
public void setPost(Post post) {
	this.post = post;
}

@ManyToOne
@JoinColumn(name="user_id")
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public int hashCode() {
	return Objects.hash(bidId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Bid other = (Bid) obj;
	return Objects.equals(bidId, other.bidId);
}
@Override
public String toString() {
	return "Bid [bidId=" + bidId + ", price=" + price + ", message=" + message + ", post=" + post + ", user=" + user
			+ "]";
}


}
