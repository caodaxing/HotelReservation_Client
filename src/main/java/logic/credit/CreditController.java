package logic.credit;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import vo.CreditVO;

/**
 * CreditController负责Credit包与界面层的交互
 * @author Xue.W
 */
public class CreditController {
	
	Credit credit = new Credit();
	CreditHistoryList chl = new CreditHistoryList();
	
	public ResultMessage changeCredit(String user_ID , CreditChange change , int number ){
		return credit.changeCredit(user_ID, change, number);
	}
	
	public int getCredit(String user_ID){
		return credit.getCredit(user_ID);
	}
	
	public ArrayList<CreditVO> getHistoryList(String user_ID){
		return chl.getHistoryList(user_ID);
	}
	
	public ResultMessage setVIPCredit(int credit_num){
		return credit.setVIPCredit(credit_num);
	}
	
}
