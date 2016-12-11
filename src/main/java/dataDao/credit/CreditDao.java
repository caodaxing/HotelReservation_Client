package dataDao.credit;

import java.util.ArrayList;

import po.CreditHistoryPO;

public interface CreditDao {
	
	public boolean changeCredit(CreditHistoryPO po);
	
	public ArrayList<CreditHistoryPO> getCreditHistory(String userID);
	
	public int getCredit(String userID);
	
	public boolean setVIPCredit(int level, int credit_num);

	public int getVIPCredit(int level);
	
}
