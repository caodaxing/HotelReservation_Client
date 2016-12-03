package viewController;

import logic.account.Account;
import logicService.account.AccountService;
import view.right.webBusiness.VIPInfo.SetVIPCredit;

public class WBVIPInfoController {
	
	//逻辑层接口
	private AccountService accountService;
	
	//控制界面
	private SetVIPCredit setVIPCreditUI;
	
	public WBVIPInfoController(){
		accountService = new Account();
	}
	
	public void setView(SetVIPCredit view){
		this.setVIPCreditUI = view;
	}
}
