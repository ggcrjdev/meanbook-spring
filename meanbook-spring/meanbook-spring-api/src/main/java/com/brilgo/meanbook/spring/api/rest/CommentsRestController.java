package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.rest.request.CommentsAddRequest;
import com.brilgo.meanbook.spring.api.rest.request.CommentsLikeRequest;
import com.brilgo.meanbook.spring.api.rest.response.CommentsAddResponse;
import com.brilgo.meanbook.spring.api.rest.response.CommentsLikeResponse;

@RestController
@RequestMapping(value = "/comments")
public class CommentsRestController {
	
	@RequestMapping(value = "/add", method = POST)
	public CommentsAddResponse add(@RequestBody CommentsAddRequest request) {
		return new CommentsAddResponse();
	}
	
	@RequestMapping(value = "/like", method = POST)
	public CommentsLikeResponse like(@RequestBody CommentsLikeRequest request) {
		return new CommentsLikeResponse();
	}
}
