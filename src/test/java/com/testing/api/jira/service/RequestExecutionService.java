package com.testing.api.jira.service;

import com.testing.api.jira.propertiesloader.PropertiesLoader;
import com.testing.api.jira.values.TemporaryValues;

public class RequestExecutionService extends BaseService{

	public void postToIssueApi() {
		response = specification.post(PropertiesLoader.getProperties().getProperty("enpoints.issue"));
		saveCreatedIssueId();
	}
	
	public void getCreatedIssueFromIssueApi() {
		response = specification.get(PropertiesLoader.getProperties().getProperty("enpoints.issue") + TemporaryValues.createdIssueId);
	}
	
	public void deleteFromIssueApi() {
		response = specification.delete(PropertiesLoader.getProperties().getProperty("enpoints.issue") + TemporaryValues.createdIssueId);
	}
	
	private void saveCreatedIssueId() {
		TemporaryValues.createdIssueId = response.getBody().jsonPath().get("id");
	}
}
