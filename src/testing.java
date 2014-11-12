import java.net.*;
import java.io.*;

import databaseMethods.SwitchMethods;
import model.QOTD.QOTDModel;
import model.calendar.EncryptUserID;
import model.calendar.GetCalendarData;

public class testing {

	public static void main(String[] args) throws Exception {
		
		//EncryptUserID e = new EncryptUserID();
		//String userID = "anha13ao";
        //System.out.println(getText("http://calendar.cbs.dk/events.php/"+userID+"/"+e.getKey(userID)+".json"));

		SwitchMethods sw = new SwitchMethods();
		QOTDModel QOTDKlasse = new QOTDModel();
		String reply = QOTDKlasse.getQuote();
		
		//String reply = sw.deleteEvent("1");
		//String reply = sw.getEvent("1");
		//String reply = sw.getCalendar("testCalendar");
		//String reply = sw.createEvent("1", "Solbjerg", "1", "2008-11-11 13:23:44", "2008-11-11 13:23:44", "testevent", "dette er mit nye test event", "0", "1");
		
		System.out.println(reply);
	}
	public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
    }

}
