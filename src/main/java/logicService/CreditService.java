package logicService;

import java.util.ArrayList;
import Message.CreditChange;
import Message.ResultMessage;
import vo.CreditVO;

public interface CreditService {
	
	public ResultMessage changeCredit(String user_ID , CreditChange change , int number );
	
	public int getCredit(String user_ID);
	
	public ArrayList<CreditVO> getHistoryList(String user_ID);
	
	public ResultMessage setVIPCredit(int credit_num);
	
}
