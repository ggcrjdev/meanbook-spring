package com.brilgo.meanbook.spring.api.identity;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.brilgo.meanbook.spring.model.User;

@Component
public class IdentityManager {
	
	private static final String SESSION_USER_KEY = User.class.getName();

	public boolean isLoggedIn(HttpSession session) {
		return this.getLoggedInUser(session) != null;
	}
	
	public User getLoggedInUser(HttpSession session) {
		User curentUser = null;
		if (session.getAttribute(SESSION_USER_KEY) != null) {
			curentUser = (User) session.getAttribute(SESSION_USER_KEY);
		}
		return curentUser;
	}

	public void putUser(HttpSession session, User user) {
		session.setAttribute(SESSION_USER_KEY, user);
	}
}
