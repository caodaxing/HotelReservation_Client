package dataDao.stub;

import java.util.ArrayList;

import Message.Identity;
import dataDao.account.AccountDao;
import po.AccountPO;


public class AccountDao_Stub implements AccountDao{
	
	private ArrayList<AccountPO> pos = new ArrayList<AccountPO>();

	public AccountDao_Stub() {
		this.pos.add(new AccountPO("wyy", "6f6e37133b6207ef6a02aa64224a97ac", Identity.CLIENT.ordinal()));
		this.pos.add(new AccountPO("bcy", "c7569021bccaa534144be57f83d2b914", Identity.CLIENT.ordinal()));
		this.pos.add(new AccountPO("zdy", "6d2413e0bd56bdc227f1d7ba523631f2", Identity.CLIENT.ordinal()));
	}

	public boolean addAccount(AccountPO po) {
		return true;
	}

	public boolean modifyPassword(AccountPO po) {
		return true;
	}

	public AccountPO getAccountInfo(String accountID) {
		for(int i=0; i<pos.size(); ++i) {
			if(pos.get(i).getAccountID().equals(accountID)) {
				return pos.get(i);
			}
		}
		
		return null;
	}

	@Override
	public boolean userIDExists(String userID) {
		return false;
	}	

}