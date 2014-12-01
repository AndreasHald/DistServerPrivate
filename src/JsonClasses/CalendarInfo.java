package JsonClasses;
public class CalendarInfo implements java.io.Serializable {

		private  final long serialVersionUID = 1L;
		private String overallID = "createCalender";
		private String CalendarID;
		private String calenderName;
		private String userName;
		private int publicOrPrivate;
		
		public CalendarInfo(String string, String string2) {
			this.calenderName = string;
			this.CalendarID = string2;
		}
		//Getters and setters for everything, bitch
		public String getOverallID() {
			return overallID;
		}
		public void setOverallID(String overallID) {
			this.overallID = overallID;
		}
		public String getCalendarID(){
			return CalendarID;
		}
		public void setCalendarID(String CalendarID){
			this.CalendarID = CalendarID;
		}
		public String getCalenderName() {
			return calenderName;
		}
		public void setCalenderName(String calenderName) {
			this.calenderName = calenderName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getPublicOrPrivate() {
			return publicOrPrivate;
		}
		public void setPublicOrPrivate(int publicPrivate) {
			this.publicOrPrivate = publicPrivate;
		}
}