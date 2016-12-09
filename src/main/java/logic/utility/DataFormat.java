package logic.utility;

import java.text.DecimalFormat;

public class DataFormat {

	private static DataFormat formatData;
	
	public static DataFormat getInstance() {
		if(formatData == null) {
			formatData = new DataFormat();
		}
		
		return formatData;
	}
	
	public double formatDouble(double d) {
		DecimalFormat df = new DecimalFormat("#.00"); 
		return Double.valueOf(df.format(d));
	}
}
