package JsonClasses;

public class getCalendar implements java.io.Serializable {
	private  final long serialVersionUID = 2L;
	private String overallID = "getCalendar";
	private String createdby;
	
	public String getoverallID()
	{
		return overallID;
	}
	public void setoverallID(String overallID)
	{
		this.overallID = overallID;
	}
	
	public String getcreatedby()
	{
		return createdby;
	}
	public void setcreatedby(String createdby)
	{
		this.createdby = createdby;
	}
	
}
