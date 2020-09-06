package com.testing.api.jira.entities.issue;

import com.testing.api.jira.entities.issue.fields.Fields;

public class Issue {

	private Fields fields;

	private Issue(IssueBuilder builder) {
		this.fields = builder.fields;
	}

	public Fields getFields() {
		return fields;
	}

	public static class IssueBuilder {

		protected Fields fields;

		public IssueBuilder withFields(Fields fields) {
			this.fields = fields;
			return this;
		}

		public Issue build() {
			return new Issue(this);
		}
	}
}
