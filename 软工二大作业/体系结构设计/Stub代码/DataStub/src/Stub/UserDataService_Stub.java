package Stub;

import Interface.UserDataService;
import PO.AccountPO;
import PO.ResultMessage;

public class UserDataService_Stub implements UserDataService {

	public ResultMessage add(AccountPO po) {
		return ResultMessage.Add_Success;
	}
	
	public AccountPO find(String id) {
		return new AccountPO("user", "24", "123", true, "1111.11.11", null, "bcy", null, null, "123");
	}
	
	public ResultMessage modify(String id) {
		return ResultMessage.Modify_Success;
	}
	
	public ResultMessage delete(String id) {
		return ResultMessage.Delete_Success;
	}
}
