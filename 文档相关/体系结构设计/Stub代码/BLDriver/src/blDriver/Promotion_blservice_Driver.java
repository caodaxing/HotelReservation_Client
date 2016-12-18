package blDriver;

import java.util.Date;

import client.businesslogicservice.Promotion_blservice;
import client.StateOfLog;

public class Promotion_blservice_Driver {
	public void drive(Promotion_blservice promotion_blservice , StateOfLog stateOfLog , Date date){
		System.out.println("This is promotion_blservice_Driver");
		promotion_blservice.justVIP(stateOfLog, "wx");
		promotion_blservice.VIPdiscount(stateOfLog , "wx" , "½­ÄþÇø" , date , 3);  
	}
}
