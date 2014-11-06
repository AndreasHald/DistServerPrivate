package JsonClasses;

public class getEvents implements java.io.Serializable {

	private  final long serialVersionUID = 2L;
	private String overallID = "getEvents";
	private String username;
	
	
	public String getoverallID()
	{
		return overallID;
	}
	public void setoverallID(String overallID)
	{
		this.overallID = overallID;
	}
	
	public String getusername()
	{
		return username;
	}
	public void setusername(String username)
	{
		this.username = username;
	}
	
}
