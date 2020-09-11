package com.testing.api.jira.service;

import com.testing.api.jira.logger.Logger;

public class RequestExecutionService extends BaseService{

	public void postToApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		Logger.info("Executing POST to " + stringBuilder.toString());
		logRequest();
		response = specification.post(stringBuilder.toString());
		Logger.info("Status code: " + response.getStatusCode());
	}
	
	public void getFromApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		Logger.info("Executing GET to " + stringBuilder.toString());
		logRequest();
		response = specification.get(stringBuilder.toString());
		Logger.info("Status code: " + response.getStatusCode());
	}
	
	public void deleteFromApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		Logger.info("Executing DELETE to " + stringBuilder.toString());
		logRequest();
		response = specification.delete(stringBuilder.toString());
		Logger.info("Status code: " + response.getStatusCode());
	}
	
	public void putToApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		Logger.info("Executing PUT to " + stringBuilder.toString());
		logRequest();
		response = specification.put(stringBuilder.toString());
		Logger.info("Status code: " + response.getStatusCode());
	}
	
	public String saveCreatedIssueId() {
		return createdIssueId = response.getBody().jsonPath().get("id");
	}
	
	
}
