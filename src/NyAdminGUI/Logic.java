package NyAdminGUI;

import java.util.Calendar;
import java.sql.*;

public class Logic {
	
	private static String pswd = "admin123";
	static boolean adminSignedIn = false;
	
	public static boolean authenticateAdmin(String password){
		
		if (password.equals(pswd)){ 
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean createUser(String username, String password, String passwordRepeat){
	
		Connection conn = null;
		Statement stmt = null;
		//Resultset rs = null;
		String sql = "INSERT INTO Users (username, password)";
		
		if(password.equals(passwordRepeat)){
			
			try{
				
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String connectionUrl = "jdbc:mysql://localhost:3306/bcbs";
				String connectionUser = "root";
				String connectionPswd = "";
				
				conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPswd);
				stmt = ((Connection) conn).createStatement();
				PreparedStatement pstmt = ((Connection) conn).prepareStatement(sql);
				
				//User should be added to DB here
				errorMessage userAdded = new errorMessage("The user -" + username + "- has been added!");
				userAdded.setVisible(true);
				return true;
			}catch (Exception e){
				return false;
			}
			
		}else{
			errorMessage passwordnotmatch = new errorMessage("Make sure that the passwords match!");
			passwordnotmatch.setVisible(true);				
			return false;
		}
						
	}

	public static void removeEvent(String removeEventID){
		
		//Event should be removed here
		
	}
	

	public static boolean changeAdminPassword(String currentPassword, String newPassword,
			String passwordRepeat) {
		
		if(newPassword.equals(passwordRepeat)){
		
			if(currentPassword.equals(pswd)){
			pswd = newPassword;
			errorMessage passwordchanged = new errorMessage("The administrator password is changed successfully!");
			passwordchanged.setVisible(true);
			return true;
			}else{
			errorMessage wrongpassword = new errorMessage("The existing password does not match");	
			wrongpassword.setVisible(true);
			return false;	
			}
		}else{
			errorMessage passwordnotmatch = new errorMessage("Make sure that the passwords match!");
			passwordnotmatch.setVisible(true);
			return false;
			}

	}
	
	public static void removeUser(String username){
		//Method for removing user goes here <==
	}
	
	 
	
}