package JsonClasses;

public class CreateNote implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "createNote";
	private String noteId;
	private String noteText;
	private String noteCreatedBy;
	private String noteActive;
	private String eventid;
	
	public CreateNote(String noteId, String noteText, String noteCreatedBy, String noteEventID) {
		
		this.noteId = noteId;
		this.noteText = noteText;
		this.noteCreatedBy = noteCreatedBy;
		this.eventid = eventid;
	}
	
	//Getters and setters 
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public String getNoteCreatedBy() {
		return noteCreatedBy;
	}
	public void setNoteCreatedBy(String noteCreatedBy) {
		this.noteCreatedBy = noteCreatedBy;
	}
	
	public String getNoteActive() {
		return noteActive;
	}
	public void setNoteActive(String noteActive) {
		this.noteCreatedBy = noteActive;
	}
	
	public String geteventid() {
		return eventid;
	}
	public void seteventid(String eventid) {
		this.eventid = eventid;
	}

}
