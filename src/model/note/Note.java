package model.note;

import java.sql.SQLException;

import model.Model;
import model.QueryBuild.*;

public class Note extends Model{
	
	NoteModel notes = new NoteModel(0, null, null, null, 0, 0, 0);
	QueryBuilder qb = new QueryBuilder(); 
	
		public void CreateNote(
			int noteID,
			String text, 
			String dateTime, 
			String createdBy, 
			int isActive, 
			int eventID,
			int permission)	{
			
			String nId = String.valueOf(noteID);
			String eId = String.valueOf(eventID);
			String aID = String.valueOf(isActive);
			String pID = String.valueOf(permission);
			
			String[] fields = {"noteId", "eventId", "createdBy", "text", "dateTime", "active", "permission"};
			String[] values = {nId, eId, createdBy, text, dateTime, aID, pID};
			try {
				qb.insertInto("notes", fields).values(values).Execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Sletter valgte note 
		public void DeleteNote (int noteID, int permission) throws SQLException {
			if(permission != 0){
				notes = GetNote(noteID);
				notes.setActive(0);
				SaveNote(notes);
			} else {
				System.out.println("Permission denied!");
			}
		}

		// Henter note fra databasen
		public NoteModel GetNote (int noteID) throws SQLException{
			try {
				resultSet = qb.selectFrom("notes").where("noteID", "= ", String.valueOf(noteID)).ExecuteQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			while(resultSet.next()){
				notes = new NoteModel(
					resultSet.getInt("noteID"), 
					resultSet.getString("text"), 
					resultSet.getString("dateTime"), 
					resultSet.getString("createdBy"), 
					resultSet.getInt("Active"), 
					resultSet.getInt("Permission"),
					noteID);
			}
			return notes;
		}
		
		// Opretter og gemmer den valgte note
		public void SaveNote (NoteModel note){
			String text = note.getText();
			String dateTime = note.getDateTime();
			String createdBy = note.getCreatedBy();
			int isActive = note.isActive();
			int permission = note.getPermission();

			int eventID = note.getEventID();
			int noteID = note.getNoteID();
			
			String[] fields = {"eventID", "createdBy", "text", "dateTime", "Active", "Permission"};
			String[] values = {String.valueOf(noteID), text, dateTime, createdBy, String.valueOf(isActive), String.valueOf(permission)};
			qb.update("notes", fields, values).where("noteID", "=", String.valueOf(noteID));
		}
}
