package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.rest.response.UsersCurrentResponse;
import com.brilgo.meanbook.spring.api.rest.response.UsersListResponse;
import com.brilgo.meanbook.spring.api.rest.response.UsersLogoutResponse;
import com.brilgo.meanbook.spring.model.User;
import com.brilgo.meanbook.spring.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersRestController {
	
	@Autowired private UserService userService;

	@RequestMapping(value = "/list", method = GET)
	public UsersListResponse list() {
		UsersListResponse users = new UsersListResponse();
		users.getUsers().addAll(this.userService.getOnlineUsers());
		return users;
	}
	
	@RequestMapping(value = "/current", method = POST)
	public UsersCurrentResponse getCurrent() {
		UsersCurrentResponse response = new UsersCurrentResponse(false, null);
		return response;
	}
	
	@RequestMapping(value = "/login", method = POST)
	public User login(User user) {
		User loggedUser = this.userService.login(user);
		return loggedUser;
	}
	
	@RequestMapping(value = "/logout", method = POST)
	public UsersLogoutResponse logout() {
		this.userService.logout();
		return new UsersLogoutResponse(true);
	}
}
