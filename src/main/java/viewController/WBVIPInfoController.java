package viewController;

import javafx.stage.Stage;
import logic.account.Account;
import logicService.account.AccountService;
import view.right.webBusiness.VIPInfo.SetVIPCredit;

public class WBVIPInfoController {
	
	private Stage stage;
	
	//逻辑层接口
	private AccountService accountService;
	
	//控制界面
	private SetVIPCredit setVIPCreditUI;
	
	public WBVIPInfoController(Stage stage){
//		accountService = new Account();
		this.stage = stage;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setSetVIPCreditView(){
		stage.setScene(setVIPCreditUI.getScene());
	}
}
