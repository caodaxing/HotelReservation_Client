package logictest.stub;

import Message.Identity;
import Message.ResultMessage;
import logicService.AccountService;
import vo.AccountVO;
import vo.UserInfoVO;

public class AccountService_Stub implements AccountService{
	
//	public ResultMessage register(String username , String password1 , String password2){
//		if(username == "kkdki" && password1 == "166526" && password2 == "166525")
//			return ResultMessage.UNMATCHED_PASSWORD;
//		else if(username == "kkdkk" && password1 == "166526" && password2 == "166526"){
//			return ResultMessage.USERNAME_NOT_EXIST;
//		}
//		else return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage login(String username , String password){
//		if(username == "kkdki" && password == "166525"){
//			return ResultMessage.UNMATCHED_PASSWORD;
//		}else if(username == "kkdk3" && password == "166526"){
//			return ResultMessage.USERNAME_NOT_EXIST;
//		}else return ResultMessage.SUCCESS;
//	}
	
	public ResultMessage Logout(String username , String password){
		return ResultMessage.SUCCESS;
	}
	
	public UserInfoVO registerVIP(ResultMessage userstate , String username , String VIPtype){
		return new UserInfoVO("kkdki","RegularMember","0");
	}

	public ResultMessage register(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage login(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage logout(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Identity getIdentity(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
