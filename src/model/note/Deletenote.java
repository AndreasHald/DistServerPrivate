package model.note;
import java.sql.SQLException;

import model.*;

public class Deletenote {
	public static void main (String [] args) throws SQLException{
		int nId = 4;
		
		Note note = new Note();
		note.DeleteNote(nId);
	}
}