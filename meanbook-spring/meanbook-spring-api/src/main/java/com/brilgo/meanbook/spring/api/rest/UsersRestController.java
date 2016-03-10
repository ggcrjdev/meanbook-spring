package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.identity.IdentityManager;
import com.brilgo.meanbook.spring.api.rest.request.UsersLoginRequest;
import com.brilgo.meanbook.spring.api.rest.response.UsersCurrentResponse;
import com.brilgo.meanbook.spring.api.rest.response.UsersListResponse;
import com.brilgo.meanbook.spring.api.rest.response.UsersLogoutResponse;
import com.brilgo.meanbook.spring.model.User;
import com.brilgo.meanbook.spring.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersRestController {

	@Autowired private IdentityManager identityManager;
	
	@Autowired private UserService userService;

	@RequestMapping(value = "/list", method = GET)
	public UsersListResponse list() {
		UsersListResponse users = new UsersListResponse();
		users.getUsers().addAll(this.userService.getOnlineUsers());
		return users;
	}
	
	@RequestMapping(value = "/current", method = POST)
	public UsersCurrentResponse getCurrent(HttpSession session) {
		UsersCurrentResponse response = new UsersCurrentResponse();
		if (this.identityManager.isLoggedIn(session)) {
			response.setAuthenticated(true);
			response.setUsername(this.identityManager.getLoggedInUser(session).getUsername());
		}
		return response;
	}
	
	@RequestMapping(value = "/login", method = POST)
	public User login(HttpSession session, @RequestBody UsersLoginRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		User loggedUser = this.userService.login(user);
		this.identityManager.putUser(session, user);
		return loggedUser;
	}
	
	@RequestMapping(value = "/logout", method = POST)
	public UsersLogoutResponse logout(HttpSession session) {
		try {
			this.userService.logout(this.identityManager.getLoggedInUser(session));
			session.invalidate();
			return new UsersLogoutResponse(true);
		} catch (Exception e) {
			return new UsersLogoutResponse(false);
		}
	}
}
