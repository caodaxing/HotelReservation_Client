package viewController;

import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.stub.AccountService_Stub;
import view.account.FirstUI;
import view.helpTools.OneButtonDialog;
import view.right.webBusiness.VIPInfo.Blank;
import view.right.webBusiness.VIPInfo.SetVIPCredit;
import view.right.webBusiness.credit.RechargeCredit;
import view.right.webBusiness.orderManagement.AbnormalOrderList;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder;
import view.right.webBusiness.promotion.First;

public class WebBusinessLeftController {
	
	protected First firstUI;
	protected RechargeCredit rechargeCreditUI;
	protected SetVIPCredit setVIPCreditUI;
	protected TodayUnexecuteOrder tunexecuteOrderUI;
	protected AbnormalOrderList abnormalOrderListUI;
	protected Blank blankUI;
	protected FirstUI first;
	
	protected AccountService accountService;
	
	private AccountController accountController;
	private ResultMessage result;
	
	protected Stage stage;
	protected String userId;
	
	public WebBusinessLeftController(){
		
		accountService = new AccountService_Stub();
		
		firstUI = new First(this);
		rechargeCreditUI = new RechargeCredit(this);
		setVIPCreditUI = new SetVIPCredit(this);
		tunexecuteOrderUI = new TodayUnexecuteOrder(this);
		abnormalOrderListUI = new AbnormalOrderList(this);
		blankUI = new Blank(this);
	}
	
	public WebBusinessLeftController(Stage stage, String userId){
		this();
		this.userId = userId;
		this.stage = stage;
	}
	
	public void setBlankView(){
		blankUI = new Blank(this);
		stage.setScene(blankUI.getScene());
		stage.show();
	}
	
	public void setFirstVeiw(){
		firstUI = new First(this);
		stage.setScene(firstUI.getScene());
		stage.show();
	}
	
	public void setRechargeCreditView(){
		rechargeCreditUI = new RechargeCredit(this);
		stage.setScene(rechargeCreditUI.getScene());
		stage.show();
	}
	
	public void setVIPLevelView(){
		setVIPCreditUI = new SetVIPCredit(this);
		stage.setScene(setVIPCreditUI.getScene());
		stage.show();
	}
	
	public void setTodayUnexecuteOrderView(){
		tunexecuteOrderUI = new TodayUnexecuteOrder(this);
		stage.setScene(tunexecuteOrderUI.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderView(){
		abnormalOrderListUI = new AbnormalOrderList(this);
		stage.setScene(abnormalOrderListUI.getScene());
		stage.show();
	}
	
	public void setFirstUIView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		
		result = accountService.logout(userId);

		if(result == ResultMessage.FAILURE){
			showDialog("注销失败");
			return ;
		}
		showDialog("注销成功");
		accountController.setFirstView();
		newStage.show();
	}
	
	public void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
	public String getUserId(){
		return userId;
	}
	
	public Stage getStage(){
		return stage;
	}
}
