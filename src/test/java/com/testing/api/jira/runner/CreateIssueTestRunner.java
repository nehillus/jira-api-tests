package com.testing.api.jira.runner;

import org.testng.annotations.Factory;

import com.testing.api.jira.entities.issue.Issue;
import com.testing.api.jira.tests.JiraIssueApiTests;

public class CreateIssueTestRunner {

	@Factory(dataProvider = "issueDataProvider", dataProviderClass = com.testing.api.jira.dataproviders.DataProviders.class)
	public Object[] jiraCreateIssueApiTestsRunner(Issue issue) {
		return new Object[] { new JiraIssueApiTests(issue) };
	}
}
