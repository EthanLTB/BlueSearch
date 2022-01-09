package com.wadocoder.BlueSearch.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
private Long commentId;
private String commentDetails;
private LocalDateTime createdDate;
private User user;
private Post post;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
public Long getCommentId() {
	return commentId;
}
public void setCommentId(Long commentId) {
	this.commentId = commentId;
}
public String getCommentDetails() {
	return commentDetails;
}
public void setCommentDetails(String commentDetails) {
	this.commentDetails = commentDetails;
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

@ManyToOne
@JoinColumn(name="post_id")
public Post getPost() {
	return post;
}
public void setPost(Post post) {
	this.post = post;
}
@Override
public int hashCode() {
	return Objects.hash(commentId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Comment other = (Comment) obj;
	return Objects.equals(commentId, other.commentId);
}
@Override
public String toString() {
	return "Comment [commentId=" + commentId + ", commentDetails=" + commentDetails + ", createdDate=" + createdDate
			+ ", user=" + user + ", post=" + post + "]";
}


}
