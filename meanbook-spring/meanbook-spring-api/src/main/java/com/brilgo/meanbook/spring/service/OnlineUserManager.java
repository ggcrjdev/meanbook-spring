package com.brilgo.meanbook.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brilgo.meanbook.spring.model.User;

@Service
public class OnlineUserManager {

	public List<User> onlineUsers = new ArrayList<>();
	
	public List<User> getOnlineUsers() {
		return Collections.unmodifiableList(this.onlineUsers);
	}
	
	public void addUser(User newUser) {
		this.onlineUsers.add(newUser);
	}
	
	public void removeUser(User user) {
		this.onlineUsers.remove(user);
	}
	
}
