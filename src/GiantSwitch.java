import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Forecast.ForecastModel;
import model.QOTD.QOTDModel;
import model.calendar.Event;
import model.calendar.GetCalendarData;
import model.calendar.cbsevent;
import model.note.Note;
import JsonClasses.AuthUser;
import JsonClasses.CalendarInfo;
import JsonClasses.CreateCalender;
import JsonClasses.CreateNote;
import JsonClasses.DeleteCalender;
import JsonClasses.DeleteNote;
import JsonClasses.createEvent;
import JsonClasses.getEvents;
import JsonClasses.getNote;

import com.google.gson.*;

import config.Configurations;
import databaseMethods.SwitchMethods;

public class GiantSwitch {
	
	
	
	public String GiantSwitchMethod(String jsonString) throws SQLException, InterruptedException {

		//Events eventsKlasse = new Events(0, 0, 0, jsonString, jsonString, jsonString, jsonString, jsonString);

		Note noteKlasse = new Note();
		//ForecastModel forecastKlasse = new ForecastModel();
		QOTDModel QOTDKlasse = new QOTDModel();
		SwitchMethods SW = new SwitchMethods();
		
		Gson gson = new GsonBuilder().create();
		String answer = "";	
		//Creates a switch which determines which method should be used. Methods will be applied later on
		switch (Determine(jsonString)) {
		//If the Json String contains one of the keywords below, run the relevant method.

		/************
		 ** COURSES **
		 ************/

		case "importCalendar":
			System.out.println("Recieved importCourse");
			break;

		/**********
		 ** LOGIN **
		 **********/
		case "logIn": // DONE (MANGLER ADMIN)
			
			AuthUser AU = (AuthUser)gson.fromJson(jsonString, AuthUser.class);
			System.out.println("Recieved logIn");
			try {
				answer = SW.authenticate(AU.getAuthUserEmail(), AU.getAuthUserPassword(), AU.getAuthUserIsAdmin());
			} catch (Exception e) {
				answer = "Sql Error";
				e.printStackTrace();
			}
			
			
			break;

		case "logOut": // KUN AKTUEL FOR ADMIN/GUI
			System.out.println("Recieved logOut");
			break;

		/*************
		 ** CALENDAR **
		 *************/
		case "createCalender": // SKAL TESTES
			CreateCalender CC = (CreateCalender)gson.fromJson(jsonString, CreateCalender.class);
			System.out.println(CC.getCalenderName()+ "Den har lagt det nye ind i klassen");
			answer = SW.addNewCalender(CC.getCalenderName(), CC.getUserName(), CC.getPublicOrPrivate(), CC.getsharedto());
			break;
		
		case "deleteCalender": // VIRKER (TESTET)
			DeleteCalender DC = (DeleteCalender)gson.fromJson(jsonString, DeleteCalender.class);
			answer = SW.deleteCalender(DC.getUserName(), DC.getCalenderName());
			break;
		
		case "saveImportedCalender": // OVERFL�DIG
			
			
			break;
			
		case "getCalender": // VIRKER (TESTET)
			System.out.println("Recieved getCalender");
			CalendarInfo ci = (CalendarInfo)gson.fromJson(jsonString, CalendarInfo.class);
			answer = SW.getCalendar(ci.getUserName());
			break;

		case "getEvents": // SKAL TESTES
			System.out.println("Recieved getEvents");
			//Event GE = (Event)gson.fromJson(jsonString, Event.class);
			//try {
			//	answer = SW.getEvent(GE.getCalendarID());
			//} catch (Exception e) {
			//	answer = "Sql Error";
			//	e.printStackTrace();
			//}
			cbsevent ev = (cbsevent)gson.fromJson(jsonString, cbsevent.class);
			GetCalendarData gcd = new GetCalendarData();
			try {
				//answer = gcd.getuserevents(ev.getusername());
			} catch (Exception e) {
				answer = "Error";
				e.printStackTrace();
			}
			break;

		case "createEvent": // VIRKER (TESTET) SKAL OPDATERES MHT SAVE EVENT
			System.out.println("Recieved createEvent");
			createEvent ce = (createEvent)gson.fromJson(jsonString, createEvent.class);
			answer = SW.createEvent( ce.gettype(), ce.getlocation(), ce.getcreatedby(), ce.getstartTime(), ce.getendTime(), ce.getname(), ce.gettext(), ce.getcustomevent(), ce.getCalenderID());
			break;

		case "getEventInfo": // VIRKER (TESTET)
			System.out.println("Recieved getEventInfo");
			getEvents get = (getEvents)gson.fromJson(jsonString, getEvents.class);
			System.out.println(get.getCalenderID());
		    answer = SW.getEvent(get.getCalenderID());
			break;
			
		case "deleteEvent": // VIRKER (TESTET)
			System.out.println("Recieved deleteEvent");
			getEvents det = (getEvents)gson.fromJson(jsonString, getEvents.class);
			answer = SW.deleteEvent(det.geteventid());
		
		case "saveNote":
			System.out.println("Recieved saveNote");
			
			CreateNote cn = (CreateNote)gson.fromJson(jsonString, CreateNote.class);
			answer = SW.createNote(cn.geteventid(), cn.getNoteCreatedBy(), cn.getNoteText());
			break;

		case "getNote":
			System.out.println("Recieved getNote");
			
			getNote gn = (getNote)gson.fromJson(jsonString, getNote.class);
			answer = SW.getNote(gn.geteventid());
			
			break;
			
		case "deleteNote": // VIRKER;
			System.out.println("Recieved deleteNote");
			
			DeleteNote dn = (DeleteNote)gson.fromJson(jsonString, DeleteNote.class);
			SW.deleteNote(dn.getNoteId());
			
			
			break;

		/**********
		 ** QUOTE **
		 **********/
		case "getQuote":
			try {
				answer = QOTDKlasse.getQuote();
			} catch (Exception e) {
				answer = "error";
				e.printStackTrace();
			}
			System.out.println(answer);
			break;

		/************
		 ** WEATHER **
		 ************/

		case "getClientForecast":
			System.out.println("Recieved getClientForecast");
			ForecastModel fm = new ForecastModel();
			
			break;
		
		default:
			System.out.println("Error");
			break;
		}
		return answer;
		
	}

	//Creates a loooong else if statement, which checks the JSon string which keyword it contains, and returns the following 
	//keyword if
	public String Determine(String ID) {

		if (ID.contains("getEvents")) {
			return "getEvents";
		} else if (ID.contains("getEventInfo")) {
			return "getEventInfo";
		} else if (ID.contains("saveNote")) {
			return "saveNote";
		} else if (ID.contains("getNote")) {
			return "getNote";
		} else if (ID.contains("deleteNote")){
			return "deleteNote";
		}else if  (ID.contains("deleteCalender")){
			return "deleteCalender";
		} else if (ID.contains("getClientForecast")) {
			return "getClientForecast";
		} else if (ID.contains("saveImportedCalender")) {
			return "saveImportedCalender";
		}else if (ID.contains("importCourse")) {
			return "importCourse";
		} else if (ID.contains("exportCourse")) {
			return "exportCourse";
		} else if (ID.contains("getQuote")) {
			return "getQuote";
		} else if (ID.contains("logIn")) {
			return "logIn";
		} else if (ID.contains("logOut")) {
			return "logOut";
		} else if (ID.contains("getCalender")) {
			return "getCalender";
		} else if (ID.contains("createEvent")) {
			return "createEvent";
		} else if (ID.contains("deleteEvent")) {
			return "deleteEvent"; 
		} else if (ID.contains("createCalender")) {
			return "createCalender";
		}

		else
			return "error";
	}
	

}
