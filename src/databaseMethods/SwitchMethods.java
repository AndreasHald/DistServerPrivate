package databaseMethods;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.DateTimeSyntax;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.calendar.Events;
import model.calendar.GetCalendarData;

public class SwitchMethods extends Model
{
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();
	

	
	/**
	 * Allows the client to create a new calendar
	 * @param userName
	 * @param calenderName
	 * @param privatePublic
	 * @return
	 * @throws SQLException
	 */

	public String createNewCalender (String userName, String calenderName, int privatePublic) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		if(privatePublic == 1) // IF CALENDAR IS CBS CALENDAR
		{
			GetCalendarData gcd = new GetCalendarData();
			try {
				gcd.getDataFromCalendar(calenderName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(authenticateNewCalender(calenderName) == false)
		{
			addNewCalender(calenderName, userName, privatePublic);
			stringToBeReturned = "The new calender has been created!";
		}
		else
		{
			stringToBeReturned = "The new calender has not been created!";
		}
		
		
		return stringToBeReturned;
	}
	
	public String insertCBSEvents(Events events, String calenderName) throws SQLException
	{
		String [] fields = {"type", "location", "createdby", "startTime", "endTime", "name", "text", "customevent", "CalenderID"};
		
		for (int i = 0; i < events.getEvents().size(); i++){
			String type = "1";
			String location = events.getEvents().get(i).getLocation();
			String createdby = "1";
			ArrayList<String> startTime = events.getEvents().get(i).getStart();
			ArrayList<String> endTime = events.getEvents().get(i).getEnd();
			String name = events.getEvents().get(i).getTitle();
			String text = events.getEvents().get(i).getDescription();
			String customevent = "1"; // DETTE ER IKKE ET CUSTOM EVENT
			String CalendarID = "1";
			
			String[] values = {type, location, createdby, "9999-12-31 23:59:59","9999-12-31 23:59:59", name, text, customevent, CalendarID };

			qb.insertInto("events", fields).values(values).Execute();
			System.out.println("Event inserted" + i);
	    }
		System.out.println("done");
		return null;
	}
	
	public String getCalendar(String username) throws SQLException
	{
		resultSet = qb.selectFrom("calender").where("CreatedBy", "=", username).ExecuteQuery();
		String reply = null;
		while(resultSet.next())
		{
			reply += resultSet.toString();
		}
		
		return reply;
	}
	
	public boolean authenticateNewCalender(String newCalenderName) throws SQLException
	{
		getConn();
		boolean authenticate = false;
		
		resultSet= qb.selectFrom("calendar").where("name", "=", newCalenderName).ExecuteQuery();
				
				//("select * from test.calender where Name = '"+newCalenderName+"';");
		while(resultSet.next())
		{
			authenticate = true;
		}
		return authenticate;
	}
	
	public void addNewCalender (String newCalenderName, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"Name","active","CreatedBy","PrivatePublic"};
		String [] values = {newCalenderName,"1",userName, Integer.toString(publicOrPrivate)};
		qb.update("calendar", keys, values).all().Execute();
		
//		doUpdate("insert into test.calender (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalenderName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	/**
	 * Allows the client to delete a calendar
	 * @param userName
	 * @param calenderName
	 * @return
	 */
	public String deleteCalender (String userName, String calenderName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalender(userName, calenderName);

		return stringToBeReturned;
	}
	
	public String removeCalender (String userName, String calenderName) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calenderExists = "";
		resultSet = qb.selectFrom("calender").where("Name", "=", calenderName).ExecuteQuery();
				
//				("select * from calender where Name = '"+calenderName+"';");
		while(resultSet.next())
		{
			calenderExists = resultSet.toString();
		}
		if(!calenderExists.equals(""))
		{
			String [] value = {"createdby"};
			resultSet = qb.selectFrom(value, "calender").where("Name", "=", calenderName).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(!usernameOfCreator.equals(userName))
			{
				stringToBeReturend = "Only the creator of the calender is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"0"};
				qb.update("calendar", keys, values).where("Name", "=", calenderName).Execute();
				stringToBeReturend = "Calender has been set inactive";
			}
			stringToBeReturend = resultSet.toString();
		}
		else
		{
			stringToBeReturend = "The calender you are trying to delete, does not exists.";
		}
		
		
		
		return stringToBeReturend;
	}
	
	
	public String getEvent(String CalendarID) throws SQLException
	{	
		qb = new QueryBuilder();
		
		resultSet = qb.selectFrom("events").where("CalendarID", "=", CalendarID).ExecuteQuery();
		
		if (resultSet.next())
		{
			String reply = resultSet.getString("type");
			reply += resultSet.getString("title");
			reply += resultSet.getString("description");
			reply += resultSet.getString("location");
			reply += resultSet.getString("createdby");
			reply += resultSet.getString("description");
			reply += resultSet.getString("start");
			reply += resultSet.getString("end");
			
			return reply;
		}
		else
		{
			return "The Calendar doens't exist";
		}
	}
	
	// Metoden faar email og password fra switchen (udtrukket fra en json) samt en boolean der skal saettes til true hvis det er serveren der logger paa, og false hvis det er en klient
	/**
	 * Allows the client to log in
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @return
	 * @throws Exception
	 */
	public String authenticate(String email, String password, boolean isAdmin) throws Exception {

		String[] keys = {"userid", "email", "active", "password"};

		qb = new QueryBuilder();

		// Henter info om bruger fra database via querybuilder
		resultSet = qb.selectFrom(keys, "users").where("email", "=", email).ExecuteQuery();

		// Hvis en bruger med forespurgt email findes
			
		if (resultSet.next()){

			// Hvis brugeren er aktiv
			if(resultSet.getInt("active")==1)
			{					
				// Hvis passwords matcher
				if(resultSet.getString("password").equals(password))
				{
					return "0";
					// DU BLIVER LOGGET IND MEN CHECKER IKKE OM DU ER ADMIN
					
					//int userID = resultSet.getInt("userid");
					//String[] key = {"type"};
					//resultSet = qb.selectFrom(key, "roles").where("userid", "=", new Integer(userID).toString()).ExecuteQuery();
					// Hvis brugeren baade logger ind og er registreret som admin, eller hvis brugeren baade logger ind og er registreret som bruger
					// DER ER FEJL HERNEDE! 
					//if((resultSet.getString("type").equals("admin") && isAdmin) || (resultSet.getString("type").equals("user") && !isAdmin))
					//{
					//	return "0"; // returnerer "0" hvis bruger/admin er godkendt
					//} else {
					//	return "4"; // returnerer fejlkoden "4" hvis brugertype ikke stemmer overens med loginplatform
					//}
					
				} else {
					return "3"; // returnerer fejlkoden "3" hvis password ikke matcher
				}
			} else {
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som inaktiv
			}
		} else {
			return "1"; // returnerer fejlkoden "1" hvis email ikke findes
		}
	}
}
