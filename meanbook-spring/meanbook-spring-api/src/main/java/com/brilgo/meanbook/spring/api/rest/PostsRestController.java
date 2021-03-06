package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.brilgo.meanbook.spring.model.Post;
import com.brilgo.meanbook.spring.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostsRestController {
	
	@Autowired private IdentityManager identityManager;
	
	@Autowired private PostService postService;

	@RequestMapping(value = "/list/{username}/{pageNumber}", method = GET)
	public PostsListResponse list(HttpSession session, @PathVariable("username") String username,
			@PathVariable("pageNumber") Integer pageNumber) {
		String author = this.identityManager.isLoggedIn(session) ?
				this.identityManager.getLoggedInUser(session).username : username;
		List<Post> posts = this.postService.listPosts(author, pageNumber);
		return new PostsListResponse(posts);
	}
	
	@RequestMapping(value = "/add", method = POST)
	public PostsAddResponse add(@RequestBody PostsAddRequest request) {
		return PostsAddResponse.nullObject();
	}
	
	@RequestMapping(value = "/like/{id}", method = POST)
	public PostsLikeResponse like(@RequestParam(value = "id") String postId, @RequestBody PostsLikeRequest request) {
		return PostsLikeResponse.nullObject();
	}
}
