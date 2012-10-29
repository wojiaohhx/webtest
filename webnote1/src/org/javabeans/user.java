package org.javabeans;

public class user {
	public user() {
	}
	public user(int num, String name, String email) {
		this.num = num;
		this.name = name;
		this.email = email;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	private int num;
	private String name;
	private String email;
}
