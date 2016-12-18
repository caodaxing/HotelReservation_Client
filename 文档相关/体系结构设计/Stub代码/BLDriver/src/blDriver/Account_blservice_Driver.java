package blDriver;

import client.businesslogicservice.Account_blservice;
import client.StateOfLog;

public class Account_blservice_Driver {
	public void drive(Account_blservice account_blservice , StateOfLog stateOfLog){
		System.out.println("This is account_blservice_Driver");
		account_blservice.egister("wx","father");
		account_blservice.login("wx","father");
		account_blservice.logout("wx","father");
		account_blservice.registerVIP(stateOfLog,"user","A");
	}
}
