package com.testing.api.jira.service;

import com.testing.api.jira.logger.Logger;
import com.testing.api.jira.propertiesloader.PropertiesLoader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestBuilderService extends BaseService{
	
	public void addSessionCookieToRequest() {
		Logger.info("Adding JSESSIONID " + PropertiesLoader.getProperties().getProperty("JSESSIONID") + " to request");
		specification
		.cookie("JSESSIONID",PropertiesLoader.getProperties().getProperty("JSESSIONID"));
	}
	
	public void removeBodyFromRequest() {
		specification.body("");
	}
	
	public void resetRestAssured() {
		specification = RestAssured.given().contentType(ContentType.JSON);
	}
	
	public void addBodyToRequest(Object body) {
		specification.body(body);
	}
}
