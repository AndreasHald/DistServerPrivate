package NyAdminGUI;

public class Logic {
	
	private static String userName = "admin";
	private static String pswd = "admin";
	
	public static boolean authenticateAdmin(String username, 
			String password){
		String authUserName = userName;
		String authPswd = pswd;
		
		if (username == authUserName && password == authPswd){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean createUser(String username, String password, String passwordRepeat){
	
		if(password == passwordRepeat){
			
			try{
			//User Should be added to DB here
			
			return true;
			}catch (Exception e){
				return false;
			}
		}else{
				System.out.println("Password does not match");
				return false;
				//GUI Error message with password not matching
		}
						
	}
}
