package com.testing.api.jira.entities.issue.fields;

public class IssueType {
	
	private String id;
	private String name;

	public IssueType(com.testing.api.jira.enums.IssueType issueType) {
		this.name = issueType.getName();
		this.id = issueType.getId();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
