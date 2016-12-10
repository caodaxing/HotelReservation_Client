package dataDao.stub;

import java.util.ArrayList;
import java.util.Iterator;

import dataDao.CreditDao;
import po.CreditHistoryPO;

public class CreditDao_Stub implements CreditDao{

	private ArrayList<CreditHistoryPO> changeList = new ArrayList<>();
	
	public boolean changeCredit(CreditHistoryPO po) {
		if (po!=null) {
			changeList.add(po);
			return true;
		}
		return false;
	}

	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) {
		ArrayList<CreditHistoryPO> list = new ArrayList<CreditHistoryPO>();
		for (int i = changeList.size()-1; i >=0; i++) {
			if (changeList.get(i).getUserID().equals(userID)) {
				list.add(changeList.get(i));
			}
		}
		return list;
	}

	public int getCredit(String userID) {
		for (int i = changeList.size()-1 ; i>=0 ;i--) {
			if (changeList.get(i).getUserID().equals(userID)) {
				return changeList.get(i).getNowCredit();
			}
		}
		return 0;
	}

	@Override
	public boolean setVIPCredit(int level, int credit_num) {
		return true;
	}

	@Override
	public int getVIPCredit(int level) {
		return 100;
	}

}
