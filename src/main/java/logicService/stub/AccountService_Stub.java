package logicService.stub;

import Message.Identity;
import Message.ResultMessage;
import logicService.account.AccountService;
import vo.AccountVO;


public class AccountService_Stub implements AccountService{
	
	public ResultMessage register(AccountVO accountVO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage login(AccountVO accountVO) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage modifyPassword(AccountVO accountVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public Identity getIdentity(String accountID) {
		return Identity.WEBBUSSINESS;
	}

	@Override
	public ResultMessage logout(String userID) {
		return ResultMessage.SUCCESS;
	}

}
