package logic.account;

import Message.Identity;
import Message.ResultMessage;
import logicService.AccountService;
import vo.AccountVO;

/**
 * Account的controller
 * @author bcy
 *
 */
public class AccountController implements AccountService{
	Account account;
	
	public AccountController(Account account) {
		this.account = account;
	}

	public ResultMessage register(AccountVO accountVO){
		return account.register(accountVO);
	}
	
	public ResultMessage login(AccountVO accountVO) {
		return account.login(accountVO);
	}
	
	public ResultMessage logout(AccountVO accountVO){
		return account.logout(accountVO);
	}
	
	public ResultMessage modify(AccountVO accountVO){
		return account.modify(accountVO);
	}
	
	public Identity getIdentity (AccountVO accountVO){
		return account.getIdentity(accountVO);
	}
}
