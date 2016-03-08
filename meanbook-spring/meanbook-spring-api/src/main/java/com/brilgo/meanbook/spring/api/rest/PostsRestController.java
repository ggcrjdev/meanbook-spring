package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.rest.request.PostsAddRequest;
import com.brilgo.meanbook.spring.api.rest.request.PostsLikeRequest;
import com.brilgo.meanbook.spring.api.rest.response.PostsAddResponse;
import com.brilgo.meanbook.spring.api.rest.response.PostsLikeResponse;
import com.brilgo.meanbook.spring.api.rest.response.PostsListResponse;
import com.brilgo.meanbook.spring.model.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostsRestController {

	@RequestMapping(value = "/list", method = GET)
	public PostsListResponse list() {
		PostsListResponse response = new PostsListResponse();
		response.getPosts().add(new Post());
		return response;
	}
	
	@RequestMapping(value = "/add", method = POST)
	public PostsAddResponse add(PostsAddRequest request) {
		return new PostsAddResponse();
	}
	
	@RequestMapping(value = "/like/{id}", method = POST)
	public PostsLikeResponse like(PostsLikeRequest request, @RequestParam(value = "id") String postId) {
		return new PostsLikeResponse();
	}
}
