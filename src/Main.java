import java.sql.SQLException;

import model.calendar.GetCalendarData;
import GUI.GUILogic;
import config.Configurations;
import databaseMethods.SwitchMethods;

public class Main {
	//Starts public main method.
	
	public static void main(String[] args) {
		//Configurations cf = new Configurations();
		//cf.ReadFile();		
		//System.out.println(cf.getPassword());
		//new GUILogic().run();
		
		SwitchMethods sw = new SwitchMethods();
		
		
		try {
			String reply = sw.deleteCalender("Admin@admin.dk", "testCalendar");
			System.out.println(reply);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	

}
