package com.brilgo.meanbook.spring.api.rest.response;

public class UsersLogoutResponse {
	public final boolean logggedOut;
	public UsersLogoutResponse(boolean logggedOut) {
		this.logggedOut = logggedOut;
	}
	
	public static UsersLogoutResponse nullObject() {
		return new UsersLogoutResponse(false);
	}
}
