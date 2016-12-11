package viewController;

import javafx.scene.Scene;
import javafx.stage.Stage;
import logicService.account.AccountService;
import view.right.webBusiness.VIPInfo.Blank;
import view.right.webBusiness.VIPInfo.SetVIPCredit;

public class WBVIPInfoController extends WebBusinessLeftController{
	
	//逻辑层接口
	private AccountService accountService;
	
	//控制界面
	private SetVIPCredit setVIPCreditUI;
	private Blank blankUI;
	
	public WBVIPInfoController(Stage stage, String userId){
//		accountService = new Account();
		this.stage = stage;
		this.userId = userId;
		System.out.println("yes");
		setVIPCreditUI = new SetVIPCredit(this);
		blankUI = new Blank(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setSetVIPCreditView(){
		stage.setScene(setVIPCreditUI.getScene());
	}
	
	public void setBlankView(){
		stage.setScene(blankUI.getScene());
	}
	
}
