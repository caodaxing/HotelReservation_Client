package view.helpTools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import logic.utility.Time;

/**
 * 管理所需的时间信息
 * @author XueWang
 *
 */
public class TimeHelper {
	
	/**
	 * 获得当前日期的字符串
	 * @author XueWang
	 * @return String 当前日期的字符串，格式为“年月日”,如“2016-11-23”
	 */
	public static String getInstanceDateString(){
		
		String instanceDateString = "" ;
		
		Calendar c = Calendar.getInstance();
		instanceDateString += Integer.toString( c.get(Calendar.YEAR) ) +"-";
		instanceDateString += Integer.toString( c.get(Calendar.MONTH)+1 ) +"-";
		instanceDateString += Integer.toString( c.get(Calendar.DATE) );
	
		return instanceDateString ;
	
	}
	
	/**
	 * 获得现在时间
	 * @author XueWang
	 * @return Calendar 现在的时间
	 */
	public static Calendar getInstanceTime(){
		
		return Calendar.getInstance();
		
	}
	
	/**
	 * 获得当前具体时间
	 * @author XueWang
	 * @return String 当前时间字符串 格式为“hh:mm:ss”,用时注意在前面加一个空格
	 */
	public static String getInstanceTimeString(){
		//String s = Calendar.getInstance().HOUR_OF_DAY + ":" + Calendar.getInstance().MINUTE+":" + Calendar.getInstance().SECOND;
		String s = Time.getCurrentTime().substring(11);
		return s;
	}

}
