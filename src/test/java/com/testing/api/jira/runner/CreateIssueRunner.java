package com.testing.api.jira.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import com.testing.api.jira.entities.issue.Issue;
import com.testing.api.jira.factories.IssueFactory;
import com.testing.api.jira.tests.JiraIssueApiTests;

public class CreateIssueRunner {

	@Factory(dataProvider = "createIssueTestsDataProvider")
	public Object[] jiraCreateIssueApiTestsRunner(Issue issue) {
		return new Object[] { new JiraIssueApiTests(issue) };
	}

	@DataProvider
	private static Object[][] createIssueTestsDataProvider() {
		return new Object[][] { { IssueFactory.createBug() }, { IssueFactory.createTask() },
				{ IssueFactory.createStory() } };
	}
}
