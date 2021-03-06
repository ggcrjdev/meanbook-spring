package com.brilgo.meanbook.spring.api.rest.response;

import java.util.Date;

public class CommentsAddResponse {
	public final String id;
	public final String postId;
	public final String authorId;
	public final String author;
	public final Date timestamp;
	public final String text;
	public CommentsAddResponse(String id, String postId, String authorId, String author, Date timestamp, String text) {
		this.id = id;
		this.postId = postId;
		this.authorId = authorId;
		this.author = author;
		this.timestamp = timestamp;
		this.text = text;
	}
	
	public static CommentsAddResponse nullObject() {
		return new CommentsAddResponse("", "", "", "", null, "");
	}
}
