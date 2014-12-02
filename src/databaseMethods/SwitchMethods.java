package databaseMethods;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.note.Note;
import JsonClasses.CalendarInfo;

import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
	
	
	public String createNewCalender (String userName, String calenderName, int privatePublic, String sharedto) throws SQLException, InterruptedException
	{
		String stringToBeReturned ="";
		testConnection();
		if(authenticateNewCalender(calenderName) == false)
		{
			addNewCalender(calenderName, userName, privatePublic, sharedto);
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
	
	public String addNewCalender (String newCalenderName, String userName, int publicOrPrivate, String sharedto) throws SQLException, InterruptedException
	{
		// MANGLER USEREVENTS
		String [] keys = {"calname","active","CreatedBy","PrivatePublic"};
		String [] values = {userName,"1",newCalenderName, Integer.toString(publicOrPrivate)};
		qb.insertInto("calender", keys).values(values).Execute();
		
		if(sharedto != null)
		{
			share(sharedto,newCalenderName);
		}
		
		return "sucess";
		
	}
	
	public void share (String sharedto, String calendarName) throws SQLException, InterruptedException
	{
		String calid = null;
		String uid = null;
		
		
		
		System.out.println(calid);
		
		resultSet= qb.selectFrom("users").where("email", "=", sharedto).ExecuteQuery();
		
		while(resultSet.next())
		{
			uid = resultSet.getString("userid");
		}
		calid = S(calid, calendarName);
		System.out.println(calid);
		System.out.println(uid);
		
		String [] keys = {"userid","CalenderID"};
		String [] values = {uid, calid};
		qb.insertInto("userevents", keys).values(values).Execute();
	}
	
	public String S(String calid, String calendarName) throws SQLException
	{
		resultSet= qb.selectFrom("Calender").where("calname", "=", calendarName).ExecuteQuery();

		while(resultSet.next())
		{
			System.out.println("here");
			calid = resultSet.getString("CalenderID");
		}
		
		return calid;
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
		String [] temp = new String[20];
		String [] fin = new String[20];
		String reply = "";
		ArrayList<CalendarInfo> Cal = new ArrayList<CalendarInfo>();;
		
		resultSet = qb.selectFrom("userevents").where("userid", "=", userID).ExecuteQuery();
		int counter = 0;
		while(resultSet.next())
		{
			temp[counter] = resultSet.getString("CalenderID");
			counter ++;
		}
		
		
			resultSet = qb.selectFrom("Calender").all().ExecuteQuery();
			while(resultSet.next())
			{
				for (int i=0; i<temp.length; i++)
				{
				if(resultSet.getString("Active").equals("1") && resultSet.getString("CalenderID").equals(temp[i]))
					
					Cal.add(new CalendarInfo(resultSet.getString("calname"),resultSet.getString("CalenderID")));
					//Cal[i].setCalenderName(resultSet.getString("calname"));
					//Cal[i].setCalendarID(resultSet.getString("CalenderID"));
				}
			}
		
		reply = gson.toJson(Cal);
		
		
		if (reply.equals(""))
		{
			reply = "Calendar wasn't found";
		}
		
		System.out.println(reply);
		
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


		resultSet = qb.selectFrom("Calender").where("calname", "=", calenderName).ExecuteQuery();

//				("select * from calender where Name = '"+calenderName+"';");
		while(resultSet.next())
		{
			calenderExists = resultSet.toString();
		}
		System.out.println(calenderExists);
		if(!calenderExists.equals(""))
		{

			String [] value = {"CreatedBy"};
			resultSet = qb.selectFrom(value, "Calender").where("calname", "=", calenderName).ExecuteQuery();
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
				qb.update("calender", keys, values).where("calname", "=", calenderName).Execute();
				stringToBeReturend = "Calender has been deleted";
			}
		}
		else
		{
			stringToBeReturend = "The calender you are trying to delete, does not exists.";
		}
		return stringToBeReturend;
	}
	
	
	public String getEvent(String CalendarID) throws SQLException
	
	{
		String reply = "";
		ArrayList<JsonClasses.createEvent> CE = new ArrayList<JsonClasses.createEvent>();;
		qb = new QueryBuilder();
		System.out.println(CalendarID);
		resultSet = qb.selectFrom("events").where("CalenderID", "=", CalendarID).ExecuteQuery();
		//Cal.add(new CalendarInfo(resultSet.getString("calname"),resultSet.getString("CalenderID")));
		//CE.add(new JsonClasses.createEvent
		while (resultSet.next())
		{
			if(resultSet.getString("Active").equals("1"))
			{
				CE.add(new JsonClasses.createEvent(resultSet.getString("eventid"), resultSet.getString("type"), resultSet.getString("location"), resultSet.getString("createdby"), resultSet.getString("startTime"), resultSet.getString("endTime"), resultSet.getString("name"), resultSet.getString("text")));
			}
		}
		return reply = gson.toJson(CE);
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
