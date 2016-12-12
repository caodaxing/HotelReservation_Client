package logic.utility;

public class TimeSection {

	private Time start;
	private Time end;
	
	public TimeSection(String start, String end) {
		this.start = new Time(start);
		this.end = new Time(end);
	}
	
	public boolean includeTime(String time) { 
		Time t = new Time(time);
		
		if(t.after(start) && t.before(this.end) && !this.end.sameDay(t)) {
			return true;
		}
		
		return false;
	}
	
}
