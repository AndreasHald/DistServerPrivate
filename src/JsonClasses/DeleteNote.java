package JsonClasses;

public class DeleteNote implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteNote";
	private String noteId;
	
	private int publicOrPrivate;
	
	//Getters and setters 
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public int getNoteId() {
		return Integer.parseInt(noteId);
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	
	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}
	public void setPublicOrPrivate(int publicPrivate) {
		this.publicOrPrivate = publicPrivate;
	}

}