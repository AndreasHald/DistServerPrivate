package model.note;
import java.sql.SQLException;

import model.*;

public class Testnote {
	public static void main (String [] args) throws SQLException{
		
		String text = "Test tekst";
		String cb = "createdBy admin";
		int eID = 11;
		int aID = 1;
		
		Note note = new Note();
		note.CreateNote(text, cb, aID, eID);
		//note.DeleteNote();
	}
}
