package com.brilgo.meanbook.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.brilgo.meanbook.spring.model.Post;
import com.brilgo.meanbook.spring.repository.PostRepository;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PostService {

	@Autowired private PostRepository postRepository;
	
	public List<Post> listPosts(String author) {
		return this.postRepository.listByAuthor(author);
	}
}
