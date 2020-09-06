package com.testing.api.jira.enums;

public enum IssueType {

	TASK("Задача","10003"),
	SUBTASK("Подзадача","10004"),
	STORY("История","10002"),
	EPIC("Epic","10001"),
	BUG("Ошибка", "10005");
	
	String id;
	String name;
	
	IssueType(String name, String id) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
