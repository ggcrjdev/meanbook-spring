package com.brilgo.meanbook.spring.api.rest.wrapper;

import java.util.ArrayList;
import java.util.List;

public class UsersWrapper {
	
	public UsersWrapper() {
	}
	
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
