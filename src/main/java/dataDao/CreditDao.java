package dataDao;

import java.util.ArrayList;

import po.CreditHistoryPO;

public interface CreditDao {
	
	public boolean changeCredit(CreditHistoryPO po);
	
	public ArrayList<CreditHistoryPO> getCreditHistory(String userID);
	
	public int getCredit(String userID);
	
}
