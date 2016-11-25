package driver;

import Message.Identity;
import Message.ResultMessage;
import logicService.AccountService;
import vo.AccountVO;

/**
 * AccountBLService 的 Driver
 * @author XueWang
 */
public class AccountDriver {
	
	AccountVO vo = new AccountVO("123" , "123456" , Identity.CLIENT);
	
	public void drive(AccountService accountService){
		
		System.out.println("This is accountServiceDriver");
		
		ResultMessage result0 = accountService.register(vo);
		if(result0 == ResultMessage.SUCCESS){
			System.out.println("Register success");
		}else if(result0 == ResultMessage.FAILURE){
			System.out.println("Register fail");
		}else{
			System.out.println("Error");
		}
		
		ResultMessage result1 = accountService.login(vo);
		if(result1 == ResultMessage.SUCCESS){
			System.out.println("Login success");
		}else if(result1 == ResultMessage.FAILURE){
			System.out.println("Login fail");
		}else if(result1 == ResultMessage.UNMATCHED_PASSWORD){
			System.out.println("Wrong password");
		}else if(result1 == ResultMessage.USERNAME_NOT_EXIST){
			System.out.println("Wrong username");
		}
		
		Identity id = accountService.getIdentity(vo);
		System.out.println("This is a " + id);
		
		ResultMessage result2 = accountService.modifyPassword(vo);
		if(result2 == ResultMessage.SUCCESS){
			System.out.println("Modify success");
		}else if(result2 == ResultMessage.FAILURE){
			System.out.println("Modify Fail");
		}else{
			System.out.println("Error");
		}
		
		ResultMessage result3 = accountService.modifyPassword(vo);
		if(result3 == ResultMessage.SUCCESS){
			System.out.println("Logout success");
		}else if(result3 == ResultMessage.FAILURE){
			System.out.println("Logout Fail");
		}else{
			System.out.println("Error");
		}
	
	}
	
}
