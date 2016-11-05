package logic.account;

import Message.Identity;
import Message.ResultMessage;
import vo.AccountVO;

public class Account {
	String user_id;
	String password;
	Identity identity;
	
	public ResultMessage register(AccountVO accountVO){
		return ResultMessage.Add_Success;
	}
	
	public ResultMessage login(AccountVO accountVO) {
		return ResultMessage.Login_Success;
	}
	
	public ResultMessage logout(AccountVO accountVO){
		return ResultMessage.Logout_Success;
	}
	
	public ResultMessage modify(AccountVO accountVO){
		return ResultMessage.Modify_Success;
	}
	
	public Identity getIdentity (AccountVO accountVO){
		return Identity.Client;
	}
}
