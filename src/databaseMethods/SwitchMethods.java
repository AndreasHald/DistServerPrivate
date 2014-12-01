package databaseMethods;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.DateTimeSyntax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import JsonClasses.CalendarInfo;
import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.note.Note;

public class SwitchMethods extends Model
{
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();
	Gson gson = new Gson();
	

	
	/**
	 * Allows the client to create a new calendar
	 * @param userName
	 * @param calenderName
	 * @param privatePublic
	 * @return
	 * @throws SQLException
	 */

	public boolean createuser(String userName, String password) throws SQLException
	{
		String[] keys = {"email", "active", "password"};
		String[] values = {userName, "1", password};
		qb.insertInto("users", keys).values(values).Execute();
		return true;
	}
	
	
	public String createNewCalender (String userName, String calenderName, int privatePublic) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
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
	
	public String deleteEvent (String eventid)
	{
		try {
			qb.deleteFrom("events").where("eventid", "=", eventid).Execute();
			return "success";
		} catch (SQLException e) {
			
			e.printStackTrace();
			return "fejl";
		}
	}
	
	public String addNewCalender (String newCalenderName, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"Name","active","CreatedBy","PrivatePublic"};
		String [] values = {userName,"1",newCalenderName, Integer.toString(publicOrPrivate)};
		qb.insertInto("calender", keys).values(values).Execute();
		
		return "sucess";
		
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
		System.out.println(userName + calenderName);
		stringToBeReturned = removeCalender(userName, calenderName);

		return stringToBeReturned;
	}
	
	public String getCalendar (String userID) throws SQLException
	{
		String temp = "";
		String reply = "";
		CalendarInfo ci = new CalendarInfo();
		
		resultSet = qb.selectFrom("userevents").where("userid", "=", userID).ExecuteQuery();
		
		while(resultSet.next())
		{
			temp = resultSet.getString("CalenderID");
		}
		
		resultSet = qb.selectFrom("calender").where("CalenderID", "=", temp).ExecuteQuery();
		
		while(resultSet.next())
		{
			ci.setCalenderName(resultSet.getString("Name"));
			ci.setCalendarID(resultSet.getString("CalenderID"));
		}
		reply = gson.toJson(ci);
		
		if (reply.equals(""))
		{
			reply = "Calendar wasn't found";
		}
		
		return reply;
	}
	
	public String createEvent(String type, String location, String createdby, String startTime, String endTime, String name, String text, String customevent,String CalenderID) throws SQLException
	{
		String [] keys = {"type", "location", "createdby", "startTime", "endTime", "name", "text", "customevent", "CalenderID"};
		String [] values = {type, location, createdby, startTime, endTime, name, text, customevent, CalenderID};
		
		qb.insertInto("events", keys).values(values).Execute();
		
		return  "1"; 
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
		System.out.println(calenderExists);
		if(!calenderExists.equals(""))
		{

			String [] value = {"CreatedBy"};
			resultSet = qb.selectFrom(value, "Calender").where("Name", "=", calenderName).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.getString("CreatedBy");
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
				qb.update("calender", keys, values).where("Name", "=", calenderName).Execute();
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
		System.out.println(CalendarID);
		resultSet = qb.selectFrom("events").where("CalenderID", "=", CalendarID).ExecuteQuery();
		
		if (resultSet.next())
		{
			String reply = resultSet.getString("eventid");
			reply = resultSet.getString("type");
			reply += resultSet.getString("location");
			reply += resultSet.getString("createdby");
			reply += resultSet.getString("startTime");
			reply += resultSet.getString("endTime");
			reply += resultSet.getString("name");
			reply += resultSet.getString("text");
			reply += resultSet.getString("customevent");
			
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
					return "0" + resultSet.getString("userid");
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
	
	public String createNote(int nId, String text, String cb, int aId, int eId){
		String stringToBeReturned = "";
		
		Note note = new Note();

		//return note.CreateNote(nId, text, cb, aId, eId);
	}
	public String deleteNote(int nId){
		Note note = new Note();
		
		//return note.DeleteNote(nId);
	}
	
}
