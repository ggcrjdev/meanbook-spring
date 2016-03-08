package com.brilgo.meanbook.spring.api.rest.response;

public class PostsLikeResponse {
	
	private String postId;
	private Integer numLikes;
	
	public PostsLikeResponse() {
	}

	public PostsLikeResponse(String postId, Integer numLikes) {
		super();
		this.postId = postId;
		this.numLikes = numLikes;
	}
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Integer getNumLikes() {
		return numLikes;
	}
	public void setNumLikes(Integer numLikes) {
		this.numLikes = numLikes;
	}
}
