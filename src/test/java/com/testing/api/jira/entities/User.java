package com.testing.api.jira.entities;

import com.testing.api.jira.propertiesloader.PropertiesLoader;

public class User {
	
	private String username;
	private String password;
	
	public User() {
		this.username = PropertiesLoader.getProperties().getProperty("username");
		this.password = PropertiesLoader.getProperties().getProperty("password");
	}
}
