package dataDao.stub;

import java.util.ArrayList;

import dataDao.CreditDao;
import po.CreditHistoryPO;

public class CreditDao_Stub implements CreditDao{

	public boolean changeCredit(CreditHistoryPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCredit(String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
