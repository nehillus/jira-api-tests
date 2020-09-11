package com.testing.api.jira.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {
	
	protected String createdIssueId;

	protected static Response response;
	protected static RequestSpecification specification = RestAssured.given().contentType(ContentType.JSON);
	
	protected void logRequest() {
		specification.log().body();
		specification.log().headers();
		specification.log().cookies();
		specification.log().parameters();
	}
}
