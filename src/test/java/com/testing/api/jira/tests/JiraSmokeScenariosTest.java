package com.testing.api.jira.tests;

import org.testng.annotations.Test;

import com.testing.api.jira.basetest.BaseTest;

import junit.framework.Assert;

public class JiraSmokeScenariosTest extends BaseTest{
	
	@Test
	public void createNewBugTest() {
		requestBuilderService.addSessionCookieToRequest();
		requestBuilderService.addBugBodyToRequest();
		requestExecutionService.postToIssueApi();
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
	
	@Test(dependsOnMethods = "createNewBugTest", priority = 1)
	public void getCreatedBugTest() {
		requestBuilderService.addSessionCookieToRequest();
		requestExecutionService.getCreatedIssueFromIssueApi();
		Assert.assertTrue(responseAssertionService.assertCreatedIssueIsReturned());
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
	
	@Test(dependsOnMethods = "createNewBugTest", priority = 2)
	public void deleteCreatedBugTest() {
		requestBuilderService.addSessionCookieToRequest();
		requestExecutionService.deleteFromIssueApi();
		Assert.assertTrue(responseAssertionService.assertStatusCode2xx());
	}
}
