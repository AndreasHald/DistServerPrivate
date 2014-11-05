package model.note;

import java.sql.SQLException;

/*
 * 		Mangler:
 * 			- Identifikation på brugeren der har lavet noten
 * 			- Hvem der skal kunne redigere noten
 * 			- Mulighed for at slette / redigere noter
 * 			- Active Status
 * 
 * 			ETA: 2 timer
 */

public class NoteModel {
	
	private int noteID;
	private String text;
	private String dateTime;
	private String createdBy;
	private int Active;
	private int eventID;
	
	public NoteModel(int noteID, String text, String dateTime, String createdBy, int Active, int eventID) {
		super();
		this.noteID = noteID;
		this.text = text;
		this.dateTime = dateTime;
		this.createdBy = createdBy;
		this.Active = Active;
		this.eventID = eventID;
	}
	
	public int getEventID() {
		return eventID;
	}


	public void setEventID(int eventID) {
		this.eventID = eventID;
	}


	public int Active() {
		return Active;
	}


	public void setActive(int Active) {
		this.Active = Active;
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
