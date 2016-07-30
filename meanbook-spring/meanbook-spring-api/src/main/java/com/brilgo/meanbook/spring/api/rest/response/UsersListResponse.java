package com.brilgo.meanbook.spring.api.rest.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.brilgo.meanbook.spring.model.User;

public class UsersListResponse {
	public final List<User> users;
	public UsersListResponse(List<User> users) {
		this.users = Collections.unmodifiableList(users);
	}
	
	public static UsersListResponse nullObject() {
		return new UsersListResponse(new ArrayList<User>(0));
	}
}
