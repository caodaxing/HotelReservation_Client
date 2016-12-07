package viewController;

import javafx.stage.Stage;
import logic.account.Account;
import logic.credit.Credit;
import logicService.account.AccountService;
import logicService.credit.CreditService;
import view.right.webBusiness.credit.RechargeCredit;

public class WBCreditController {
	
	private Stage stage;
	
	//逻辑层接口
	private CreditService creditService;
	private AccountService accountService;
	
	//控制的界面
	private RechargeCredit rechargeCreditUI;
	
	public WBCreditController(Stage stage){
		
//		creditService = new Credit();
//		accountService = new Account();
		this.stage = stage;
		rechargeCreditUI = new RechargeCredit(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setRechargeCreditView(){
		stage.setScene(rechargeCreditUI.getScene());
	}
	
}
