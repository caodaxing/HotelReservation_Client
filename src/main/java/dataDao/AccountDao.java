package dataDao;

import po.AccountPO;

public interface AccountDao {
	public boolean addAccount(AccountPO po);
	
	public boolean modifyPassword(AccountPO po);
	
	public AccountPO getAccountInfo(AccountPO po);
}
