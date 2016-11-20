package factories;

import logic.account.Account;
import logic.user.UserController;

/**
 * 创建logic service实例的工厂
 * @author Mark.W
 *
 */
public class ServiceFactory {

	private static ServiceFactory serviceFactory;
	
	private Account account;
	
	private UserController userController;
	
	public static ServiceFactory getInstance() {
		if(serviceFactory == null) {
			serviceFactory = new ServiceFactory();
		}
		
		return serviceFactory;
	}
	
	public Account createAccount(){
		if(account == null) {
			account = new Account();
		}
		return account;
	}
	
	
}
