package logic.utility;

import java.text.DecimalFormat;

public class DataFormat {
	
	public static double formatDouble(double d) {
		DecimalFormat df = new DecimalFormat("#.00"); 
		return Double.valueOf(df.format(d));
	}
}
