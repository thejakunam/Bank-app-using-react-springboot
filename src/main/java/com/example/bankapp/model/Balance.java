package com.example.bankapp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="balance")
public class Balance {
	
	@Id
	private String id;

	private String username;
	private String bankaccno;
	private String bankbal;
	
	public Balance() {
		
	}

	public Balance(String id, String username, String bankaccno, String balance) {
		this.id = id;
		this.username = username;
		this.bankaccno = bankaccno;
		this.bankbal = balance;
	}
	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getbankaccno() {
		return bankaccno;
	}

	public void setbankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

	public String getBalance() {
		return bankbal;
	}

	public void setBalance(String balance) {
		this.bankbal = balance;
	}
	

}
