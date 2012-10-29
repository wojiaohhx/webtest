package org.bean;

import java.util.ArrayList;

public class NoteBook {
	private int id;
	private int ownerId;
	private String name;
	private int notesNum;
	private String descirption;
	private ArrayList <Note> notesList;

	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
	public int getNotesNum() {
		return notesNum;
	}
	public void setNotesNum(int notesNum) {
		this.notesNum = notesNum;
	}
	public String getDescirption() {
		return descirption;
	}
	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}
	public ArrayList<Note> getNotesList() {
		return notesList;
	}
	public void setNotesList(ArrayList<Note> notesList) {
		this.notesList = notesList;
	}
	
}
