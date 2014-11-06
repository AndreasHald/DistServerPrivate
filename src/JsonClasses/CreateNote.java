package JsonClasses;

public class CreateNote implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "createNote";
	private String noteId;
	private String noteText;
	private String noteCreatedBy;
	private String noteActive;
	private String noteEventID;
	
	private int publicOrPrivate;
	
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
	
	public String getNoteEventID() {
		return noteEventID;
	}
	public void setNoteEventID(String noteEventID) {
		this.noteEventID = noteEventID;
	}
	
	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}
	public void setPublicOrPrivate(int publicPrivate) {
		this.publicOrPrivate = publicPrivate;
	}

}
