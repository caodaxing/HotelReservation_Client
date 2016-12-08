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

	private int len = "yyyy-MM-dd".length();
	private String hourMinSec = " 00:00:00";
	private String time;
	
	public Time(String time) {
		if(time.length() < len) {
			time = time.trim() + hourMinSec;
		}
		
		this.time = time;
	}
	
	
}
