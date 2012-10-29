package org.bean;

public class Note {
	private String title;
	private String content;
	private String createDate;
	private String modifyDate;
	private int id;
	private int noteBookId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoteBookId() {
		return noteBookId;
	}
	public void setNoteBookId(int noteBookId) {
		this.noteBookId = noteBookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getNoteID() {
		return id;
	}
	public void setNoteID(int noteID) {
		this.id = noteID;
	}
}
