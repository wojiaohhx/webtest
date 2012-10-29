package org.bean;

import java.util.ArrayList;

import bean.NoteBook;

public class User {
	private int id;
	private String name;
	private String password;
	private String emailAddress;
	private String captcha;
	private boolean captchaFlag;
	private ArrayList <NoteBook> noteBookList;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public boolean isCaptchaFlag() {
		return captchaFlag;
	}
	public void setCaptchaFlag(boolean captchaFlag) {
		this.captchaFlag = captchaFlag;
	}
	public ArrayList<NoteBook> getNoteBookList() {
		return noteBookList;
	}
	public void setNoteBookList(ArrayList<NoteBook> noteBookList) {
		this.noteBookList = noteBookList;
	}
}
