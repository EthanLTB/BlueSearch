package com.wadocoder.BlueSearch.dto;

public class CommentDto {

	private String commentDetails;
	private Long userId;
	private Long postId;
	
	public String getCommentDetails() {
		return commentDetails;
	}
	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	
}
