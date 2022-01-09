package com.br.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String psw;
	
	
	
	public User() {
		super();
	}

	public User(int id, String name, String email, String psw) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.psw = psw;
	}
	
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
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	
}
