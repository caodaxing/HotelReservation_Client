package view.helpTools;

import java.util.Calendar;

/**
 * 管理所需的时间信息
 * @author XueWang
 *
 */
public class TimeHelper {
	
	/**
	 * 获得当前日期的字符串
	 * @author XueWang
	 * @return String 当前日期的字符串，格式为“年月日”,如“20161123”
	 */
	public static String getInstanceDateString(){
		
		String instanceDateString = "" ;
		
		Calendar c = Calendar.getInstance();
		instanceDateString += Integer.toString( c.get(Calendar.YEAR) ) ;
		instanceDateString += Integer.toString( c.get(Calendar.MONTH)+1 ) ;
		instanceDateString += Integer.toString( c.get(Calendar.DATE) );
	
		return instanceDateString ;
	
	}
	
	/**
	 * 用到的所有颜色和字体信息
	 * @author XueWang
	 * @return Calendar 现在的时间
	 */
	public static Calendar getInstanceTime(){
		
		return Calendar.getInstance();
		
	}

}
