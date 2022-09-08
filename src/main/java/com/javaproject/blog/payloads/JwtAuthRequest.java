package com.javaproject.blog.payloads;

public class JwtAuthRequest {
	//we consider email as a username
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
