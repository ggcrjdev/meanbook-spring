package com.brilgo.meanbook.spring.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.rest.wrapper.User;
import com.brilgo.meanbook.spring.api.rest.wrapper.UsersWrapper;

@RestController
@RequestMapping(value = "/users")
public class UsersRestController {

	@RequestMapping(value = "/list")
	public UsersWrapper list() {
		UsersWrapper users = new UsersWrapper();
		users.getUsers().add(new User("ggc", "ggc"));
		return users;
	}
}
