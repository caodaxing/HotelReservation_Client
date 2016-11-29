package logic.credit;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import vo.CreditHistoryVO;

/**
 * CreditController负责Credit包与界面层的交互
 * @author Xue.W
 */
public class CreditController {
	
	CreditHistory creditHistory;
	Credit credit;
	
	public ResultMessage changeCredit(String user_ID , CreditChange change , int number ){
		return credit.changeCredit(user_ID, change, number);
	}
	
	public int getCredit(String user_ID){
		return credit.getCredit(user_ID);
	}
	
	public ArrayList<CreditHistoryVO> getHistoryList(String user_ID){
		return creditHistory.getHistoryList(user_ID);
	}
	
	public ResultMessage setVIPCredit(int credit_num){
		return credit.setVIPCredit(credit_num);
	}
	
}
