package com.brilgo.meanbook.spring.api.rest.response;

import java.util.Date;

public class PostsAddResponse {
	
	private String id;
	private String authorId;
	private String author;
	private Date timestamp;
	private String text;
	
	public PostsAddResponse() {
	}

	public PostsAddResponse(String id, String authorId, String author, Date timestamp, String text) {
		super();
		this.id = id;
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
