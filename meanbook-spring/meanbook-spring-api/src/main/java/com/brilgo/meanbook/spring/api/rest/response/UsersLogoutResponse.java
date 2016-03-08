package com.brilgo.meanbook.spring.api.rest.response;

public class UsersLogoutResponse {

	private boolean logggedOut;

	public UsersLogoutResponse(boolean logggedOut) {
		super();
		this.logggedOut = logggedOut;
	}

	public boolean isLogggedOut() {
		return logggedOut;
	}

	public void setLogggedOut(boolean logggedOut) {
		this.logggedOut = logggedOut;
	}
}
