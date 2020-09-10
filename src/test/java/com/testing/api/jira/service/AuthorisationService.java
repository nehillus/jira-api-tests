package com.testing.api.jira.service;

import com.testing.api.jira.api.ApiUrl;
import com.testing.api.jira.entities.User;
import com.testing.api.jira.logger.Logger;
import com.testing.api.jira.propertiesloader.PropertiesLoader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AuthorisationService extends BaseService{

	public AuthorisationService() {
		
	}
	
	public void authorizeUser() {
		if (PropertiesLoader.getProperties().getProperty("JSESSIONID") == null) {
			Logger.info("Sending authorisation request to " + ApiUrl.AUTHORISATION.getUrl());
			response = RestAssured.given().contentType(ContentType.JSON).body(new User())
					.post(ApiUrl.AUTHORISATION.getUrl());
			Logger.info("Response status: " + response.getStatusLine());
			Logger.info("Setting JSESSIONID to: " + extractJsessionId(response));
			setUserSessionCookie(response);
		}
	}

	private void setUserSessionCookie(Response response) {
		PropertiesLoader.setProperty("JSESSIONID", extractJsessionId(response));
	}

	private String extractJsessionId(Response response) {
		JsonPath responsejson = new JsonPath(response.asString());
		return responsejson.getString("session.value");
	}
}
