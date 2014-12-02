package JsonClasses;

public class createEvent implements java.io.Serializable {
	private  final long serialVersionUID = 2L;
	private String overallID = "createEvent";
	private String eventid;
	private String type;
	private String location;
	private String createdby;
	private String startTime;
	private String endTime;
	private String name;
	private String text;
	private String customevent;
	private String CalenderID;
	
	public createEvent(String eventid, String type, String location, String createdby, String startTime, String endTime, String name, String text) {
		
		this.eventid = eventid;
		this.type = type;
		this.location = location;
		this.createdby = createdby;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		this.text = text;
	}
	
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
	
	public String gettype()
	{
		return type;
	}
	
	public void settype(String type)
	{
		this.type = type;
	}
	
	public String getlocation()
	{
		return location;
	}
	
	public void setlocation(String location)
	{
		this.location = location;
	}
	
	public String getcreatedby()
	{
		return createdby;
	}
	
	public void setcreatedby(String createdby)
	{
		this.createdby = createdby;
	}
	
	public String getstartTime()
	{
		return startTime;
	}
	
	public void setstartTime(String startTime)
	{
		this.startTime = startTime;
	}
	
	public String getendTime()
	{
		return endTime;
	}
	
	public void setendTime(String endTime)
	{
		this.endTime = endTime;
	}
	
	public String getname()
	{
		return name;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public String gettext()
	{
		return text;
	}
	
	public void settext(String text)
	{
		this.text = text;
	}
	
	public String getcustomevent()
	{
		return customevent;
	}
	
	public void setcustomevent(String customevent)
	{
		this.customevent = customevent;
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
