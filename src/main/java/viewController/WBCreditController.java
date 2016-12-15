package viewController;

import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.credit.CreditChangeService;
import logicService.stub.CreditChangeService_Stub;
import view.right.webBusiness.credit.RechargeCredit;
import vo.CreditChangeVO;

public class WBCreditController extends WebBusinessLeftController{
	
	//逻辑层接口
	private CreditChangeService creditChangeService;
	private AccountService accountService;
	
	//控制的界面
	private RechargeCredit rechargeCreditUI;
	
	public WBCreditController(Stage stage, String userId){
		
//		accountService = new Account();
		this.stage = stage;
		this.userId = userId;
		creditChangeService = new CreditChangeService_Stub(userId);
		rechargeCreditUI = new RechargeCredit(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setRechargeCreditView(){
		stage.setScene(rechargeCreditUI.getScene());
	}
	
	public ResultMessage getRechargeResult(CreditChangeVO vo){
		return creditChangeService.rechargeCredit(vo);
	}
	
}
