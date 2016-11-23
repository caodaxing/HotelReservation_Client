package logic.stub;

import Message.Identity;
import Message.ResultMessage;
import logicService.AccountService;
import vo.AccountVO;


public class AccountService_Stub implements AccountService{
	
	public ResultMessage register(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage login(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.FAILURE;
	}

	public ResultMessage logout(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modifyPassword(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.FAILURE;
	}

	public Identity getIdentity(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return Identity.HOTELMANAGER;
	}

}
