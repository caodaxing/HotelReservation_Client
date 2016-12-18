package blDriver;

import java.util.HashMap;

import client.businesslogicservice.Credit_blservice;
import client.vo.OrderStateVO;
import client.vo.CreditVO;
import client.vo.AccountVO;

public class Credit_blservice_Driver {
	public void drive(Credit_blservice credit_blservice , OrderStateVO order_State,
			CreditVO credit , AccountVO userAccount){
		System.out.println("This is credit_blservice_Driver");
		credit_blservice.accountOfUser(12345 , order_State);
		credit_blservice.numberOfCredit(12345 , order_State);
		credit_blservice.changCredit(credit , userAccount);
		credit_blservice.recharge(new HashMap() , 100 );
	}
}
