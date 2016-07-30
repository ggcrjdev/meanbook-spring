package com.brilgo.meanbook.spring.api.rest.request;

public class UsernameRequest {
	public final String username;
	public UsernameRequest(String username) {
		this.username = username;
	}
	
	public UsernameRequest() {
		username = null;
	}
}
