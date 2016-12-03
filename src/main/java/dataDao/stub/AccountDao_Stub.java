package dataDao.stub;

import dataDao.account.AccountDao;
import po.AccountPO;


public class AccountDao_Stub implements AccountDao{

	public boolean addAccount(AccountPO po) {
		return true;
	}

	public boolean modifyPassword(AccountPO po) {
		return true;
	}

	public AccountPO getAccountInfo(String accountID) {
		return new AccountPO("curry", "e80b5017098950fc58aad83c8c14978e", 0);
//		return new AccountPO("kobe", "162befe78a0c20249a4bab30cca88515", 0);
	}	

}