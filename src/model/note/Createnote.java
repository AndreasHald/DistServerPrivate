package model.note;
import java.sql.SQLException;

import databaseMethods.SwitchMethods;
import model.*;

public class Createnote {
	public static void main (String [] args) throws SQLException{
		String text = "Notetekst";
		String cb = "Blabladaejadk test Frid";
		int aId = 1;
		int eID = 1;
		int nId = 0;
		
		SwitchMethods note = new SwitchMethods();
		note.createNote(nId, text, cb, aId, eID);
	}
}
