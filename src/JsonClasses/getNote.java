package JsonClasses;

public class getNote implements java.io.Serializable {
	
	private String overallID;
	private String eventid;
	
	
	public String getoverallID()
	{
		return overallID;
	}
	public void setoverallID(String overallID)
	{
		this.overallID = overallID;
	}
	
	public String geteventid()
	{
		return eventid;
	}
	public void seteventid(String eventid)
	{
		this.eventid = eventid;
	}

}
