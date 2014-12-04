package JsonClasses;

public class DeleteNote implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteNote";
	private String noteId;
	
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

}