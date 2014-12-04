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
