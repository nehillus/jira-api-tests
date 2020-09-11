package com.testing.api.jira.dataproviders;

import org.testng.annotations.DataProvider;

import com.testing.api.jira.factories.IssueFactory;

public class DataProviders {
	
	@DataProvider
	public static Object[][] issueDataProvider() {
		return new Object[][] { { IssueFactory.createBug() }, { IssueFactory.createTask() },
				{ IssueFactory.createStory() } };
	}
	
}
