package com.testing.api.jira.basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.testing.api.jira.listeners.JiraTestListener;
import com.testing.api.jira.logger.Logger;
import com.testing.api.jira.modules.JiraFrameworkModule;
import com.testing.api.jira.propertiesloader.PropertiesLoader;
import com.testing.api.jira.service.AuthorisationService;
import com.testing.api.jira.service.RequestBuilderService;
import com.testing.api.jira.service.RequestExecutionService;
import com.testing.api.jira.service.ResponseAssertionService;

import io.restassured.RestAssured;

@Listeners({JiraTestListener.class})
public class BaseTest {
	
    Injector injector = Guice.createInjector(new JiraFrameworkModule());
	
	@Inject
	protected AuthorisationService authorisationService;
	
	@Inject
	protected RequestExecutionService requestExecutionService;
	
	@Inject
	protected RequestBuilderService requestBuilderService;

	@Inject
	protected ResponseAssertionService responseAssertionService;
	
	@BeforeClass
	public void injectMembers() {
		injector.injectMembers(this);
	}
	
	@BeforeClass
	public void initBaseUri() {
		Logger.info("Setting base URI to " + PropertiesLoader.getProperties().getProperty("baseurl"));
		RestAssured.baseURI = PropertiesLoader.getProperties().getProperty("baseurl");
	}
	
	@BeforeMethod
	public void addSessionCookie() {
		authorisationService.authorizeUser();
		requestBuilderService.addSessionCookieToRequest();
	}
	
	@AfterMethod
	public void resetRequest() {
		requestBuilderService.resetRestAssured();
	}
	
	@AfterMethod
	public void clearRequestBody() {
		requestBuilderService.removeBodyFromRequest();
	}
}
