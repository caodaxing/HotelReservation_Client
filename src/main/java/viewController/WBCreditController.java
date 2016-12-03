package viewController;

import logic.account.Account;
import logic.credit.Credit;
import logicService.account.AccountService;
import logicService.credit.CreditService;
import view.right.webBusiness.credit.RechargeCredit;

public class WBCreditController {
	
	//逻辑层接口
	private CreditService creditService;
	private AccountService accountService;
	
	//控制的界面
	private RechargeCredit rechargeCreditUI;
	
	public WBCreditController(){
		creditService = new Credit();
		accountService = new Account();
	}
	
	public void setView(RechargeCredit view){
		this.rechargeCreditUI = view;
	}
	
}
