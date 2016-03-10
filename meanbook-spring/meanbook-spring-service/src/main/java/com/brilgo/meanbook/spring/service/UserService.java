package com.brilgo.meanbook.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.brilgo.meanbook.spring.model.User;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserService {

	@Autowired private OnlineUserManager onlineUserManager;
	
	public List<User> getOnlineUsers() {
		return this.onlineUserManager.getOnlineUsers();
	}

	public User login(User user) {
		user.setId(user.getUsername());
		this.onlineUserManager.addUser(user);
		return user;
	}

	public void logout(User user) {
		this.onlineUserManager.removeUser(user);
	}
}
