package com.example.bankapp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "userinfo")
public class UserInfo {

	@Id
	private String userId;

	private String username;
	
	private String firstname;
	
	private String lastname;
	
	private String city;
	
	private String state;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String username, String firstname, String lastname, String city, String state) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
