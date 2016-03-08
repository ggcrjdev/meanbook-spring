package com.brilgo.meanbook.spring.api.rest.response;

public class CommentsLikeResponse {
	
	private String commentId;
	private Integer likes;
	
	public CommentsLikeResponse() {
	}
	
	public CommentsLikeResponse(String commentId, Integer likes) {
		super();
		this.commentId = commentId;
		this.likes = likes;
	}
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
}
