package com.testing.api.jira.entities.issue.fields;

public class Project {
	
	private String key;
	
	public Project(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
