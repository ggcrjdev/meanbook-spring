package com.brilgo.meanbook.spring.api.rest.response;

import java.util.ArrayList;
import java.util.List;

import com.brilgo.meanbook.spring.model.User;

public class UsersListResponse {
	
	public UsersListResponse() {
	}
	
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
