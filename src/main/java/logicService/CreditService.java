package logicService;

import java.util.ArrayList;
import Message.CreditChange;
import vo.CreditVO;

public interface CreditService {
	
	public boolean changeCredit(String user_ID , CreditChange change , int number );
	
	public int getCredit(String user_ID);
	
	public ArrayList<CreditVO> getHistoryList(String user_ID);
	
	public boolean setVIPCredit(int credit_num);
	
}
