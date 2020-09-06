package com.testing.api.jira.factories;

import com.testing.api.jira.entities.issue.fields.Fields;
import com.testing.api.jira.entities.issue.fields.Project;
import com.testing.api.jira.enums.IssueType;
import com.testing.api.jira.propertiesloader.PropertiesLoader;

public class FieldsFactory {
	
	private static final String SAMPLE_PROJECT_NAME = "Sample Project";
	private static final String PROJECT_KEY = PropertiesLoader.getProperties().getProperty("project_key");
	private static final String SAMPLE_SUMMARY = "Sample Summary";

	public static Fields fieldsForBug() {
		return new Fields.FieldsBuilder()
				.withDescription(SAMPLE_PROJECT_NAME)
				.withIssuetype(IssueType.BUG)
				.withProject(new Project(PROJECT_KEY))
				.withSummary(SAMPLE_SUMMARY)
				.build();
	}

	public static Fields fieldsForEpic() {
		return new Fields.FieldsBuilder()
				.withDescription(SAMPLE_PROJECT_NAME)
				.withIssuetype(IssueType.EPIC)
				.withProject(new Project(PROJECT_KEY))
				.withSummary(SAMPLE_SUMMARY)
				.build();
	}
	
	public static Fields fieldsForStory() {
		return new Fields.FieldsBuilder()
				.withDescription(SAMPLE_PROJECT_NAME)
				.withIssuetype(IssueType.STORY)
				.withProject(new Project(PROJECT_KEY))
				.withSummary(SAMPLE_SUMMARY)
				.build();
	}
}
