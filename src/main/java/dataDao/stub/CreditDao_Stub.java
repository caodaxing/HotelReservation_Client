package dataDao.stub;

import java.util.ArrayList;

import Message.CreditChangeType;
import dataDao.credit.CreditDao;
import po.CreditHistoryPO;

public class CreditDao_Stub implements CreditDao{

	private int[] vipLevelCredit = new int[4];
	private ArrayList<CreditHistoryPO> pos = new ArrayList<CreditHistoryPO>();
	
	public CreditDao_Stub() {
		this.vipLevelCredit[0] = 0;
		this.vipLevelCredit[1] = 1000;
		this.vipLevelCredit[2] = 4000;
		this.vipLevelCredit[3] = 80000;
		
		pos.add(new CreditHistoryPO("wyy", "2016-11-11", "20161111000031234", CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE.ordinal(), 400, 1700));
		pos.add(new CreditHistoryPO("wyy", "2016-10-01", "20161001000051236", CreditChangeType.SET_ABNORMAL_ORDER_DECREASE.ordinal(), -400, 1300));
		pos.add(new CreditHistoryPO("wyy", "2015-12-31", null, CreditChangeType.RECHARGE_CREDIT.ordinal(), 1000, 1700));
		pos.add(new CreditHistoryPO("bcy", "2016-12-12", "20161212000561854", CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE.ordinal(), 400, 800));
		pos.add(new CreditHistoryPO("zdy", "2014-01-01", "201401011003431904", CreditChangeType.UNDO_ABNORAML_ORDER_RECOVER.ordinal(), -300, -100));
	}

	public boolean changeCredit(CreditHistoryPO po) {
		return true;
	}

	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) {
		return pos;
	}

	public int getCredit(String userID) {

		if(userID == "wyy") {
			return 1700;
		} else if(userID == "bcy") {
			return 800;
		}
		 
		return -100;
		
	}

	@Override
	public boolean setVIPCredit(int level, int credit_num) {
		return true;
	}

	@Override
	public int getVIPCredit(int level) {
		return vipLevelCredit[level];
	}

}
