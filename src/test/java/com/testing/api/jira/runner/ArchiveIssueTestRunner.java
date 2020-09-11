package com.testing.api.jira.runner;

import org.testng.annotations.Factory;

import com.testing.api.jira.entities.issue.Issue;
import com.testing.api.jira.tests.JiraArchiveIssueApiTests;

public class ArchiveIssueTestRunner {

	@Factory(dataProvider = "issueDataProvider", dataProviderClass = com.testing.api.jira.dataproviders.DataProviders.class)
	public Object[] jiraCreateIssueApiTestsRunner(Issue issue) {
		return new Object[] { new JiraArchiveIssueApiTests(issue) };
	}
}
