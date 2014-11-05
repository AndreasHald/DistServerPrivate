package model.note;

import java.sql.SQLException;

import model.Model;
import model.QueryBuild.*;

public class Note extends Model{
	
	NoteModel notes = new NoteModel(0, null, null, null, 0, 0);
	QueryBuilder qb = new QueryBuilder(); 
	
		public void CreateNote(
			int noteId,
			String text,  
			String createdBy, 
			int Active, 
			int eventID)	{
			
			String aId = String.valueOf(Active);
			String eId = String.valueOf(eventID);
			String nId = String.valueOf(noteId);
			
			String[] fields = {"noteId", "eventID", "createdBy", "text", "Active"};
			String[] values = {nId, eId, createdBy, text, aId};
			try {
				qb.insertInto("notes", fields).values(values).Execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void DeleteNote (int noteID) throws SQLException {
					notes = GetNote(noteID);
					notes.setActive(0);
					System.out.println(notes.Active());
					
					SaveNote(notes);
					
					System.out.println("Delete funktionen er kørt");
				}

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
							noteID);
				}
					return notes;
		}
		
		public void SaveNote (NoteModel note){
			
			String text = note.getText();
			String dateTime = note.getDateTime();
			String createdBy = note.getCreatedBy();
			int Active = note.Active();
			
			System.out.println("Hvad er den nye active status:" + Active);

			int eventID = note.getEventID();
			int noteID = note.getNoteID();
			
			System.out.println(eventID);
			System.out.println(noteID);
			
			String[] fields = {"noteID", "eventID", "createdBy", "text", "dateTime", "Active"};
			String[] values = {String.valueOf(noteID), String.valueOf(eventID), createdBy, text, dateTime, String.valueOf(Active)};
			qb.update("notes", fields, values).where("noteID", "=", String.valueOf(noteID));
		}
}
