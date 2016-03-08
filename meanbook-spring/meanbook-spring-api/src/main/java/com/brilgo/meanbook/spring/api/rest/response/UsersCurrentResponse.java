package com.brilgo.meanbook.spring.api.rest.response;

public class UsersCurrentResponse {
	
	private boolean authenticated;
	private String username;

	public UsersCurrentResponse(boolean authenticated, String username) {
		super();
		this.authenticated = authenticated;
		this.username = username;
	}
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
