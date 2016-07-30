package com.brilgo.meanbook.spring.api.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brilgo.meanbook.spring.api.identity.IdentityManager;
import com.brilgo.meanbook.spring.api.rest.request.UsernameRequest;
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
		List<User> users = this.userService.getOnlineUsers();
		return new UsersListResponse(users);
	}
	
	@RequestMapping(value = "/current", method = POST)
	public UsersCurrentResponse getCurrent(HttpSession session) {
		if (this.identityManager.isLoggedIn(session)) {
			return new UsersCurrentResponse(true, this.identityManager.getLoggedInUser(session).username);
		} else {
			return UsersCurrentResponse.nullObject();
		}
	}
	
	@RequestMapping(value = "/login", method = POST)
	public User login(HttpSession session, @RequestBody UsernameRequest request) {
		User user = new User(request.username);
		User loggedUser = this.userService.login(user);
		this.identityManager.putUser(session, user);
		return loggedUser;
	}
	
	@RequestMapping(value = "/logout", method = POST)
	public UsersLogoutResponse logout(HttpSession session, @RequestBody UsernameRequest request) {
		try {
			this.userService.logout(request.username);
			session.invalidate();
			return new UsersLogoutResponse(true);
		} catch (Exception e) {
			return new UsersLogoutResponse(false);
		}
	}
}
