package model.note;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import model.Model;
import model.QueryBuild.*;

public class Note extends Model{
	
	NoteModel notes = new NoteModel(0, null, null, null, 0, 0);
	QueryBuilder qb = new QueryBuilder(); 
	
		public String CreateNote(
			int nId, 
			String text,  
			String createdBy, 
			int isActive, 
			int eventID)	{
			
			String aId = String.valueOf(isActive);
			String eId = String.valueOf(eventID);
			
			String[] fields = {"eventId", "createdBy", "text", "active"};
			String[] values = {eId, createdBy, text, aId};
			try {
				qb.insertInto("notes", fields).values(values).Execute();
				
				return "New note created";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return "Could not create note. Please try again.";
			}
		}

		public String DeleteNote (int noteID){
			String stringToBeReturned = "";
			
			try {
				notes = GetNote(noteID);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				stringToBeReturned = "Could not GetNote with ID="+noteID+". Therefor the process of deleting this note has been aborted.";
			}
			notes.setActive(0);
			try {
				SaveNote(notes);
				stringToBeReturned = "Note with ID="+noteID+" deleted succesfully";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				stringToBeReturned = "Could not delete note with ID=" + noteID +". Please try again.";
			}
			return stringToBeReturned;	
		}

		public NoteModel GetNote (int noteID) throws SQLException{
			
			try {
				resultSet = qb.selectFrom("notes").where("noteID", "= ", String.valueOf(noteID)).ExecuteQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				while(resultSet.next()){
					notes = new NoteModel(
							resultSet.getInt("noteID"), 
							resultSet.getString("text"), 
							resultSet.getString("dateTime"), 
							resultSet.getString("createdBy"), 
							resultSet.getInt("Active"), 
							noteID);
				}
					return notes;
				
			
		
		}
		
		public void SaveNote (NoteModel note) throws SQLException{
			
			String text = note.getText();
			String dateTime = note.getDateTime();
			String createdBy = note.getCreatedBy();
			int isActive = note.isActive();

			int eventID = note.getEventID();
			int noteID = note.getNoteID();
			
			String[] fields = {"eventID", "createdBy", "text", "dateTime", "Active"};
			String[] values = {String.valueOf(eventID), createdBy, text, dateTime,  String.valueOf(isActive)};
			
			qb.update("notes", fields, values).where("noteID", "=", String.valueOf(noteID)).Execute();
				
		}
}
