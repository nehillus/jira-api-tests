package com.testing.api.jira.service;

import java.util.regex.Pattern;



public class ResponseAssertionService extends BaseService{
	
	private static final String STATUS_CODE_2XX = "2\\d{2}";
	
	public boolean assertStatusCode2xx() {
		return Pattern.matches(STATUS_CODE_2XX, Integer.toString(response.getStatusCode()));
	}
	
	public boolean assertCreatedIssueIsReturned(String expectedIssueId) {
		return response.getBody().jsonPath().get("id").equals(expectedIssueId);
	}
}
