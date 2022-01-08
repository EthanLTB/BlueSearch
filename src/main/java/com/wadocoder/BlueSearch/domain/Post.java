package com.wadocoder.BlueSearch.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
private Long postId;
private String jobDescription;
private LocalDateTime createdDate;
private User user;
private List<Comment> comments;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
public Long getPostId() {
	return postId;
}
public void setPostId(Long postId) {
	this.postId = postId;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public LocalDateTime getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDateTime createdDate) {
	this.createdDate = createdDate;
}
@ManyToOne
@JoinColumn(name="user_id")
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}
@Override
public int hashCode() {
	return Objects.hash(postId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Post other = (Post) obj;
	return Objects.equals(postId, other.postId);
}
@Override
public String toString() {
	return "Post [postId=" + postId + ", jobDescription=" + jobDescription + ", createdDate=" + createdDate + ", user="
			+ user + ", comments=" + comments + "]";
}


}
