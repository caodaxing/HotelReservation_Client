package logic.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于时间的比较
 * @author Mark.W
 *
 */
public class Time {
	
	public static String getCurrentTime() {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t =format.format(date);
		
		return t;
	}

	private int minlen = "yyyy-MM-dd".length();
	private String hourMinSec = " 00:00:00";
	private String time;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private int sec;
	
	
	public Time(String time) {

		if(time.length() <= minlen) {
			time = time.trim() + hourMinSec;
		}
		
		if(time.length() == 19) {
			this.time = time;
			this.initTime();
		}
	}
	

	
	@Override
	public String toString() {
		return this.time;
	}



	private void initTime() {
		this.year = Integer.parseInt(this.time.substring(0, 4));
		this.month = Integer.parseInt(this.time.substring(5, 7));
		this.day = Integer.parseInt(this.time.substring(8, 10));
		this.hour = Integer.parseInt(this.time.substring(11, 13));
		this.min = Integer.parseInt(this.time.substring(14, 16));
		this.sec = Integer.parseInt(this.time.substring(17, 19));
	}

	public boolean before(Time t) {
		return this.year < t.getYear() ? true :
			this.year > t.getYear() ?  false :
				this.month < t.getMonth() ? true :
					this.month > t.getMonth() ? false :
						this.day < t.getDay() ? true : 
							this.day > t.getDay() ? false :
								this.hour < t.getHour() ? true : 
									this.hour > t.getHour() ? false :
										this.min < t.getMin() ? true :
											this.min > t.getMin() ? false :
												this.sec < t.getSec() ? true :
													this.sec > t.getSec() ? false:
														true;
	}
	
	public boolean after(Time t) {
		return this.year < t.getYear() ? false :
			this.year > t.getYear() ?  true :
				this.month < t.getMonth() ? false :
					this.month > t.getMonth() ? true :
						this.day < t.getDay() ? false : 
							this.day > t.getDay() ? true :
								this.hour < t.getHour() ? false : 
									this.hour > t.getHour() ? true :
										this.min < t.getMin() ? false :
											this.min > t.getMin() ? true :
												this.sec < t.getSec() ? false :
													this.sec > t.getSec() ? true:
														true;
	}
	
	public boolean sameDay(Time t) {
		if(this.month == t.getMonth() && this.day == t.getDay()) {
			return true;
		}
		
		return false;
	}
	
	public boolean sameTime(Time t) {
		if(this.year == t.getYear() && this.month == t.getMonth() && this.day == t.getDay()
				&& this.hour == t.getHour() && this.min == t.getMin() && this.sec == t.getSec()) {
			return true;
		}
		
		return false;
	}
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMinlen() {
		return minlen;
	}

	public String getTime() {
		return time;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMin() {
		return min;
	}

	public int getSec() {
		return sec;
	}

	
}
