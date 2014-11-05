package model.note;
import java.sql.SQLException;

import model.*;

public class Createnote {
	public static void main (String [] args) throws SQLException{
		String text = "Notetekst";
		String cb = "Mikkel Frid";
		int aId = 1;
		int eID = 1;
		int nId = 0;
		
		Note note = new Note();
		note.CreateNote(nId, text, cb, aId, eID);
	}
}
