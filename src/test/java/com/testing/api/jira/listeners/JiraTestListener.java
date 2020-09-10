package com.testing.api.jira.listeners;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.testing.api.jira.basetest.annotations.Priority;
import com.testing.api.jira.logger.Logger;

public class JiraTestListener implements ITestListener{
	
	public void onTestStart(ITestResult iTestResult) {
		Logger.info("Beginning test execution for method " + iTestResult.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult iTestResult) {
		Logger.info(iTestResult.getMethod().getMethodName() + " method was completed successfully.");
	}

	public void onTestFailure(ITestResult iTestResult) {
		Logger.info(iTestResult.getMethod().getMethodName() + " test failed.");

	}

	public void onTestSkipped(ITestResult iTestResult) {
		Logger.info("Skipped test " + iTestResult.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		Logger.info(iTestResult.getMethod().getMethodName() + " test failed.");
	}

	public void onStart(ITestContext iTestContext) {
		Logger.info(String.format("BEGINNING TEST RUN IN CLASS %s", iTestContext.getClass().getName()));
	}

	public void onFinish(ITestContext iTestContext) {
		Logger.info(String.format("ENDING TEST RUN IN CLASS %s", iTestContext.getClass().getName()));
	}
}
