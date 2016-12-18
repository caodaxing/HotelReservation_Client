package Stub;

import Interface.AccountBLService;
import VO.ResultMessage;
import VO.UserInfoVO;

public class AccountBLService_Stub implements AccountBLService{
	
	public ResultMessage register(String username , String password1 , String password2){
		if(username == "kkdki" && password1 == "166526" && password2 == "166525")
			return ResultMessage.Register_unmatchpassword;
		else if(username == "kkdkk" && password1 == "166526" && password2 == "166526"){
			return ResultMessage.Register_usernameexit;
		}
		else return ResultMessage.Register_Success;
	}
	
	public ResultMessage login(String username , String password){
		if(username == "kkdki" && password == "166525"){
			return ResultMessage.Login_unmatchpassword;
		}else if(username == "kkdk3" && password == "166526"){
			return ResultMessage.Login_unexitusername;
		}else return ResultMessage.Login_Success;
	}
	
	public ResultMessage Logout(String username , String password){
		return ResultMessage.Logout_Success;
	}
	
	public UserInfoVO registerVIP(ResultMessage userstate , String username , String VIPtype){
		return new UserInfoVO("kkdki","RegularMember","0");
	}
}
