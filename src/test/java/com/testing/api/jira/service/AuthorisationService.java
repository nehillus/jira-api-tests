package com.testing.api.jira.service;

import com.testing.api.jira.entities.User;
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
			response = RestAssured.given().contentType(ContentType.JSON).body(new User())
					.post(PropertiesLoader.getProperties().getProperty("endpoints.authorisation"));
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
