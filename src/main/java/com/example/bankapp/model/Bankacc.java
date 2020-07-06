package com.example.bankapp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="bankacc")
public class Bankacc {
	
	@Id
	private String userId;
	private String bankaccno;

	private String username;
	
	private String bankname;
	
	
	
	public Bankacc() {
		
	}

	public Bankacc(String userId,String username, String bankname, String bankaccno) {
		this.userId = userId;
		this.username = username;
		this.bankname = bankname;
		this.bankaccno = bankaccno;
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

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankaccno() {
		return bankaccno;
	}

	public void setBankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

}
