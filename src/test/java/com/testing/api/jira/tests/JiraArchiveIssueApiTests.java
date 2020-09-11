package com.testing.api.jira.tests;

import org.testng.annotations.Test;

import com.testing.api.jira.api.ApiUrl;
import com.testing.api.jira.basetest.BaseTest;
import com.testing.api.jira.entities.issue.Issue;

import junit.framework.Assert;

public class JiraArchiveIssueApiTests extends BaseTest{

	private Issue issueUnderTest;
	private String createdissueId;
	
	public JiraArchiveIssueApiTests(Issue issueUnderTest) {
		this.issueUnderTest = issueUnderTest;
	}
	
	@Test
	public void archiveIssueTest() {
		requestBuilderService.addBodyToRequest(issueUnderTest);
		requestExecutionService.postToApi(ApiUrl.ISSUE.getUrl());
		createdissueId = requestExecutionService.saveCreatedIssueId();
		requestBuilderService.removeBodyFromRequest();
		requestExecutionService.putToApi(ApiUrl.ISSUE.getUrl(), createdissueId, "archive");
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
}
