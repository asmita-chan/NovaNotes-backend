package dev.novanotes.backend.bean;

public class StatusBean {
	private String StatusCode;
	private String GeneratedCode;
	private LoginResponse loginResponse;
	
	public StatusBean(String statusCode, String generatedCode, LoginResponse loginResponse) {
		super();
		StatusCode = statusCode;
		GeneratedCode = generatedCode;
		this.loginResponse = loginResponse;
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
	public LoginResponse getLoginResponse() {
		return loginResponse;
	}
	public void setLoginResponse(LoginResponse loginResponse) {
		this.loginResponse = loginResponse;
	}
}
