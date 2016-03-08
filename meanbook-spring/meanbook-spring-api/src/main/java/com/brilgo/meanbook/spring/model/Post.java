package com.brilgo.meanbook.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private String id;
	private String author;
	private Date timestamp;
	private String text;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Integer getCommentsCount() {
		return this.comments.size();
	}
	public boolean isHasComments() {
		return !this.comments.isEmpty();
	}
}
