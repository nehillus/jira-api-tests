package com.testing.api.jira.modules;

import com.google.inject.AbstractModule;
import com.testing.api.jira.service.AuthorisationService;
import com.testing.api.jira.service.RequestBuilderService;
import com.testing.api.jira.service.RequestExecutionService;
import com.testing.api.jira.service.ResponseAssertionService;

public class JiraFrameworkModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AuthorisationService.class)
		.toInstance(new AuthorisationService());
		bind(RequestBuilderService.class)
		.toInstance(new RequestBuilderService());
		bind(RequestExecutionService.class)
		.toInstance(new RequestExecutionService());
		bind(ResponseAssertionService.class)
		.toInstance(new ResponseAssertionService());
	}
}
