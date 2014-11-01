package model.note;
import java.sql.SQLException;

import model.*;

public class Testnote {
	public static void main (String [] args) throws SQLException{
		String text = "Notetekst";
		String cb = "createdBy brugernavn";
		int aId = 1;
		int eID = 11;
		
		Note note = new Note();
		note.CreateNote(text, cb, aId, eID);
		//note.DeleteNote(nID);
	}
}
