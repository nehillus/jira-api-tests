package com.testing.api.jira.entities.issue.fields;

public class Fields {
	
	private Project project;
	private String summary;
	private IssueType issuetype;
	private String description;
	
	private Fields(FieldsBuilder builder) {
		this.project = builder.project;
		this.summary = builder.summary;
		this.issuetype = builder.issuetype;
		this.description = builder.description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public IssueType getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static class FieldsBuilder {

		protected Project project;
		protected String summary;
		protected IssueType issuetype;
		protected String description;

		public FieldsBuilder withProject(Project project) {
			this.project = project;
			return this;
		}

		public FieldsBuilder withSummary(String summary) {
			this.summary = summary;
			return this;
		}

		public FieldsBuilder withIssuetype(com.testing.api.jira.enums.IssueType issueType) {
			this.issuetype = new IssueType(issueType);
			return this;
		}

		public FieldsBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Fields build() {
			return new Fields(this);
		}
	}
	
}
