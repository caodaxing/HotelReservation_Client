package viewController;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.account.Account;
import logic.credit.Credit;
import logic.order.ManageOrder;
import logic.order.Order;
import logic.promotion.ManagePromotion;
import logicService.account.AccountService;
import logicService.credit.CreditService;
import logicService.order.ManageOrderService;
import logicService.order.OrderService;
import logicService.promotion.ManagePromotionService;
import view.account.FirstUI;
import view.helpTools.OneButtonDialog;
import view.right.webBusiness.VIPInfo.Blank;
import view.right.webBusiness.VIPInfo.SetVIPCredit;
import view.right.webBusiness.credit.RechargeCredit;
import view.right.webBusiness.orderManagement.AbnormalOrderList;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder;
import view.right.webBusiness.promotion.First;
import vo.OrderVO;
import vo.PromotionVO;

public class WebBusinessLeftController {
	
	protected First firstUI;
	protected RechargeCredit rechargeCreditUI;
	protected SetVIPCredit setVIPCreditUI;
	protected TodayUnexecuteOrder tunexecuteOrderUI;
	protected AbnormalOrderList abnormalOrderListUI;
	protected Blank blankUI;
	protected FirstUI first;
	
	protected AccountService accountService;
	private CreditService creditService;
	private ManageOrderService manageOrderService;
	private OrderService orderService;
//	private ManagePromotionService promotionService;
	
	
	private AccountController accountController;
	private ResultMessage result;
	
	protected Stage stage;
	protected String userId;
	protected String orderId;
//	protected String promotionId;
	protected ArrayList<OrderVO> orderList;
//	protected ArrayList<PromotionVO> promotionList;
	
	
	public WebBusinessLeftController(Stage stage, String userId){
		this.userId = userId;
		this.stage = stage;
		
		accountService = new Account();
		creditService = new Credit();
		manageOrderService = new ManageOrder();
		orderService = new Order();
//		promotionService = new ManagePromotion();
		
		firstUI = new First(this);
		rechargeCreditUI = new RechargeCredit(this);
		setVIPCreditUI = new SetVIPCredit(this);
//		tunexecuteOrderUI = new TodayUnexecuteOrder(this);
//		abnormalOrderListUI = new AbnormalOrderList(this);
		blankUI = new Blank(this);
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
		setVIPCreditUI.setText();
		stage.setScene(setVIPCreditUI.getScene());
		stage.show();
	}
	
	//设置未执行列表内容
	public void setFilterUnexecuteOrderList(){
		orderList = manageOrderService.getWebDailyUnexecutedOrderList();
	}
	
	//设置异常列表内容
	public void setFilterAbnormalOrderList(){
		orderList = manageOrderService.getWebDailyAbnormalOrderList();
	}
	
	public void setTodayUnexecuteOrderView(){
		orderId = null;
		setFilterUnexecuteOrderList();
		TodayUnexecuteOrder tunexecuteOrderUI = new TodayUnexecuteOrder(this);
		tunexecuteOrderUI.initialData();
		stage.setScene(tunexecuteOrderUI.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderView(){
		orderId = null;
		setFilterAbnormalOrderList();
		AbnormalOrderList abnormalOrderListUI = new AbnormalOrderList(this);
		abnormalOrderListUI.initialData();
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
		newStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			 @Override
	         public void handle(WindowEvent event) {
				accountController.logout();
	         }
		});
		newStage.setResizable(false);
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
	
	public ResultMessage getSetVIPResult(int level, int credit_Num){
		return creditService.setVIPCredit(level, credit_Num);
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return orderList;
	}
	
	public boolean getUserIdExistResult(String userId){
		return accountService.userIDExists(userId);
	}
	
	public int getLevelCredit(int level){
		return creditService.getVIPCredit(level);
	}
	
}
