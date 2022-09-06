package com.javaproject.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

public class UserDto {
	private int id;
	
	@NotBlank
	@Size(min = 4, message = "username must be minimum 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid!")
	private String email;
	
	@NotBlank
	private String about;
	
	@NotBlank
	@Size(min = 3, max = 10, message = "Password must be minimum 3 and maximum 10 characters")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
