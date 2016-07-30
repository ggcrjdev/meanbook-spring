package com.brilgo.meanbook.spring.api.rest.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.brilgo.meanbook.spring.model.Post;

public class PostsListResponse {
	public final List<Post> posts;
	public final int postsCount;
	public PostsListResponse(List<Post> posts) {
		this.posts = Collections.unmodifiableList(posts);
		this.postsCount = posts.size();
	}
	
	public static PostsListResponse nullObject() {
		return new PostsListResponse(new ArrayList<Post>(0));
	}
}
