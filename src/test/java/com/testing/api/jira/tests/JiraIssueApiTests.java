package com.testing.api.jira.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.testing.api.jira.api.ApiUrl;
import com.testing.api.jira.basetest.BaseTest;
import com.testing.api.jira.entities.issue.Issue;
import com.testing.api.jira.logger.Logger;

import junit.framework.Assert;

public class JiraIssueApiTests extends BaseTest{
	
	private Issue issueUnderTest;
	private String createdissueId;

	public JiraIssueApiTests(Issue issueUnderTest) {
		this.issueUnderTest = issueUnderTest;
	}

	@Test
	public void createNewIssueTest() {
		requestBuilderService.addBodyToRequest(issueUnderTest);
		requestExecutionService.postToApi(ApiUrl.ISSUE.getUrl());
		createdissueId = requestExecutionService.saveCreatedIssueId();
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
	
	@Test(dependsOnMethods = "createNewIssueTest")
	public void updateCreatedIssueTest() {
		requestBuilderService.addBodyToRequest(issueUnderTest);
		requestExecutionService.putToApi(ApiUrl.ISSUE.getUrl(), createdissueId);
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
	
	@Test(dependsOnMethods = "createNewIssueTest")
	public void getCreatedIssueTest() {
		requestExecutionService.getFromApi(ApiUrl.ISSUE.getUrl(), createdissueId);
		Assert.assertTrue(responseAssertionService.assertCreatedIssueIsReturned(createdissueId));
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
	
	@Test(priority = 1)
	public void deleteCreatedBugTest() {
		requestExecutionService.deleteFromApi(ApiUrl.ISSUE.getUrl(), createdissueId);
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
	
	@AfterClass
	public void cleanUp() {
		requestExecutionService.getFromApi(ApiUrl.ISSUE.getUrl(), createdissueId);
		Logger.info("Cleaning up");
		if (responseAssertionService.assertStatusCode2xx()) {
			requestExecutionService.deleteFromApi(ApiUrl.ISSUE.getUrl(), createdissueId);
		}
	}
}
