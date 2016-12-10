package dataDao.stub;

import java.util.ArrayList;

import Message.Identity;
import dataDao.account.AccountDao;
import po.AccountPO;


public class AccountDao_Stub implements AccountDao{
	
	private ArrayList<AccountPO> pos = new ArrayList<AccountPO>();

	public AccountDao_Stub() {
		this.pos.add(new AccountPO("wyy", "e80b5017098950fc58aad83c8c14978e", Identity.CLIENT.ordinal()));
		this.pos.add(new AccountPO("bcy", "162befe78a0c20249a4bab30cca88515", Identity.CLIENT.ordinal()));
		this.pos.add(new AccountPO("zdy", "e80b5017098950fc58aad83c8c14978e", Identity.CLIENT.ordinal()));
	}

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