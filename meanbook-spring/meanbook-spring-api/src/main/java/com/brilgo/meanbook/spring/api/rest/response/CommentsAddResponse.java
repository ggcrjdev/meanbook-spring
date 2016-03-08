package com.brilgo.meanbook.spring.api.rest.response;

import java.util.Date;

public class CommentsAddResponse {
	
	private String id;
	private String postId;
	private String authorId;
	private String author;
	private Date timestamp;
	private String text;
	
	public CommentsAddResponse() {
	}

	public CommentsAddResponse(String id, String postId, String authorId, String author, Date timestamp, String text) {
		super();
		this.id = id;
		this.postId = postId;
		this.authorId = authorId;
		this.author = author;
		this.timestamp = timestamp;
		this.text = text;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
