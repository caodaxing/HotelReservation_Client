package Stub;

import java.util.HashMap;

import Interface.CreditBLService;
import VO.CreditVO;

public class CreditBLService_Stub implements CreditBLService{
	
	public CreditVO accountOfUser(int order_Number,boolean order_State){
		return new CreditVO("1200",0,"55366224");
	}
	
	public CreditVO numberOfCredit(int order_Number , boolean order_State){
		return new CreditVO("1200",50,"55366224");
	}
	
	public CreditVO changCredit (CreditVO credit , String userAccount){
		return new CreditVO("1250",50,"55366224");
	}
	
	public CreditVO recharge(HashMap<String,String> user , int money){
		return new CreditVO("1250",50,"55366224");
	}
}
