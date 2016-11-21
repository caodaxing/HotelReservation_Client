package logictest.stub;

import java.util.ArrayList;
import java.util.HashMap;

import Message.CreditChange;
import Message.ResultMessage;
import logicService.CreditService;
import vo.CreditVO;

public class CreditService_Stub implements CreditService{
	
//	public CreditVO accountOfUser(int order_Number,boolean order_State){
//		return new CreditVO("1200",0,"55366224");
//	}
//	
//	public CreditVO numberOfCredit(int order_Number , boolean order_State){
//		return new CreditVO("1200",50,"55366224");
//	}
//	
//	public CreditVO changCredit (CreditVO credit , String userAccount){
//		return new CreditVO("1250",50,"55366224");
//	}
//	
//	public CreditVO recharge(HashMap<String,String> user , int money){
//		return new CreditVO("1250",50,"55366224");
//	}

	public ResultMessage changeCredit(String user_ID, CreditChange change, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCredit(String user_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<CreditVO> getHistoryList(String user_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setVIPCredit(int credit_num) {
		// TODO Auto-generated method stub
		return null;
	}
}
