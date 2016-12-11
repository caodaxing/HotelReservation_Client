package dataDao.account;

import po.AccountPO;

public interface AccountDao {
	public boolean addAccount(AccountPO po);
	
	public boolean modifyPassword(AccountPO po);
	
	public AccountPO getAccountInfo(String accountID);
	
	public boolean userIDExists(String userID);
}