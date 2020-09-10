package com.testing.api.jira.service;

public class RequestExecutionService extends BaseService{

	public void postToApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		response = specification.log().all().post(stringBuilder.toString());
	}
	
	public void getFromApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		response = specification.log().all().get(stringBuilder.toString());
	}
	
	public void deleteFromApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		response = specification.log().all().delete(stringBuilder.toString());
	}
	
	public void putToApi(String apiUrl, Object... params) {
		StringBuilder stringBuilder = new StringBuilder(apiUrl);
		for (Object param : params) {
			stringBuilder.append(param);
			stringBuilder.append("/");
		}
		response = specification.log().all().put(stringBuilder.toString());
	}
	
	public String saveCreatedIssueId() {
		return createdIssueId = response.getBody().jsonPath().get("id");
	}
}
