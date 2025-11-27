package dev.novanotes.backend.bean;

public class StatusBean {
	private String StatusCode;
	private String GeneratedCode;
	private String accessToken;
	
	public StatusBean(String statusCode, String generatedCode, String accessToken) {
		super();
		StatusCode = statusCode;
		GeneratedCode = generatedCode;
		this.accessToken = accessToken;
	}
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	public String getGeneratedCode() {
		return GeneratedCode;
	}
	public void setGeneratedCode(String generatedCode) {
		GeneratedCode = generatedCode;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
