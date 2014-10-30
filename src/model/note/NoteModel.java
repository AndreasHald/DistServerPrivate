package model.note;

import java.sql.SQLException;

/*
 * 		Mangler:
 * 			- Identifikation på brugeren der har lavet noten
 * 			- Mulighed for at slette / redigere noter
 * 			
 * 		Lavet:
 * 			- Hvem der skal kunne redigere noten
 * 			- Active Status
 */

public class NoteModel {
	
	private int noteID;
	private String text;
	private String dateTime;
	private String createdBy;
	private int isActive;
	private int eventID;
	private int permission;
	
	public NoteModel(int noteID, String text, String dateTime, String createdBy, int isActive, int eventID, int permission) {
		super();
		this.noteID = noteID;
		this.text = text;
		this.dateTime = dateTime;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.eventID = eventID;
		this.permission = permission;
	}
	
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int isActive() {
		return isActive;
	}

	public void setActive(int isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	
	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
		
}
