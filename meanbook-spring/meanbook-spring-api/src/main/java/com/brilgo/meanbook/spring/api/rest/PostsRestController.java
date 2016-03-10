package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.identity.IdentityManager;
import com.brilgo.meanbook.spring.api.rest.request.PostsAddRequest;
import com.brilgo.meanbook.spring.api.rest.request.PostsLikeRequest;
import com.brilgo.meanbook.spring.api.rest.response.PostsAddResponse;
import com.brilgo.meanbook.spring.api.rest.response.PostsLikeResponse;
import com.brilgo.meanbook.spring.api.rest.response.PostsListResponse;
import com.brilgo.meanbook.spring.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostsRestController {
	
	@Autowired private IdentityManager identityManager;
	
	@Autowired private PostService postService;

	@RequestMapping(value = "/list", method = GET)
	public PostsListResponse list(HttpSession session) {
		String author = this.identityManager.isLoggedIn(session) ? this.identityManager.getLoggedInUser(session).getUsername() : null;
		PostsListResponse response = new PostsListResponse();
		response.getPosts().addAll(this.postService.listPosts(author));
		return response;
	}
	
	@RequestMapping(value = "/add", method = POST)
	public PostsAddResponse add(@RequestBody PostsAddRequest request) {
		return new PostsAddResponse();
	}
	
	@RequestMapping(value = "/like/{id}", method = POST)
	public PostsLikeResponse like(@RequestParam(value = "id") String postId, @RequestBody PostsLikeRequest request) {
		return new PostsLikeResponse();
	}
}
