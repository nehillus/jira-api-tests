package com.testing.api.jira.factories;

import com.testing.api.jira.entities.issue.Issue;

public class IssueFactory {
	
	public static Issue createBug() {
		return new Issue.IssueBuilder()
				.withFields(FieldsFactory.fieldsForBug())
				.build();
				
	}

	public static Issue createEpic() {
		return new Issue.IssueBuilder()
				.withFields(FieldsFactory.fieldsForEpic())
				.build();
	}
	
	public static Issue createStory() {
		return new Issue.IssueBuilder()
				.withFields(FieldsFactory.fieldsForStory())
				.build();
	}
}
