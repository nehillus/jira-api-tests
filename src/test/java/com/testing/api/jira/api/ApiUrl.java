package com.testing.api.jira.api;

public enum ApiUrl {
	
	AUTHORISATION("/rest/auth/1/session/"),
	ISSUE("/rest/api/2/issue/");
	
	private String url;

	private ApiUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
