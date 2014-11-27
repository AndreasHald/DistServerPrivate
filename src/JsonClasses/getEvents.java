package JsonClasses;

public class getEvents implements java.io.Serializable {

	private  final long serialVersionUID = 2L;
	private String overallID = "getEvents";
	private String CalendarID;
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
	
	public String getCalendarID()
	{
		return CalendarID;
	}
	public void setCalenderID(String CalendarID)
	{
		this.CalendarID = CalendarID;
	}
	
}
