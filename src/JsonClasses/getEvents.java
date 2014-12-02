package JsonClasses;

public class getEvents implements java.io.Serializable {

	private  final long serialVersionUID = 2L;
	private String overallID = "getEvents";
	private String CalenderID;
	private String eventid;
	
	
	public String geteventid()
	{
		return eventid;
	}
	public void seteventid(String eventid)
	{
		this.eventid = eventid;
	}
	
	public String getoverallID()
	{
		return overallID;
	}
	public void setoverallID(String overallID)
	{
		this.overallID = overallID;
	}
	
	public String getCalenderID()
	{
		return CalenderID;
	}
	public void setCalenderID(String CalenderID)
	{
		this.CalenderID = CalenderID;
	}
	
}
