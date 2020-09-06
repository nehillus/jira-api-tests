package com.testing.api.jira.service;

import com.testing.api.jira.factories.IssueFactory;
import com.testing.api.jira.propertiesloader.PropertiesLoader;

public class RequestBuilderService extends BaseService{
	
	public void addSessionCookieToRequest() {
		specification
		.cookie("JSESSIONID",PropertiesLoader.getProperties().getProperty("JSESSIONID"));
	}
	
	public void addBugBodyToRequest() {
		specification
		.body(IssueFactory.createBug());
	}
}
