package com.brilgo.meanbook.spring.api.rest.response;

import java.util.ArrayList;
import java.util.List;

import com.brilgo.meanbook.spring.model.Post;

public class PostsListResponse {

	private List<Post> posts = new ArrayList<>();
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Integer getPostsCount() {
		return this.posts.size();
	}
}
