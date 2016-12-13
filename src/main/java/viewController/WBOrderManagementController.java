package viewController;

import java.util.ArrayList;

import javafx.stage.Stage;
import logicService.order.ManageOrderService;
import logicService.order.OrderService;
import view.right.webBusiness.orderManagement.AbnormalOrder;
import view.right.webBusiness.orderManagement.AbnormalOrderList;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder;
import view.right.webBusiness.orderManagement.UnexecuteOrder;
import vo.OrderVO;

public class WBOrderManagementController extends WebBusinessLeftController{
	
	//逻辑层接口
	private OrderService orderService;
	private ManageOrderService manageOrderService;
	
	//控制界面
	private AbnormalOrder abnormalOrderUI;
	private AbnormalOrderList abnormalOrderListUI;
	private TodayUnexecuteOrder todayUnexecuteOderUI;
	protected UnexecuteOrder unexecuteeOrderUI;
	private int row;
	
	public WBOrderManagementController(Stage stage, String userId){
		//orderService = new Order();
		//manageOrderService = new ManageOrder();
		this.stage = stage;
		this.userId = userId;
		abnormalOrderUI = new AbnormalOrder(this);
		abnormalOrderListUI = new AbnormalOrderList(this);
		todayUnexecuteOderUI = new TodayUnexecuteOrder(this);
		unexecuteeOrderUI = new UnexecuteOrder(this);
	}
	
	public WBOrderManagementController(Stage stage, String userId, int row){
		this.stage = stage;
		this.userId = userId;
		this.row = row;
		todayUnexecuteOderUI = new TodayUnexecuteOrder(this);
		unexecuteeOrderUI = new UnexecuteOrder(this);
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setabnormalOrderView(){
		stage.setScene(abnormalOrderUI.getScene());
	}
	
	public void setAbnormalOrderListView(){
		stage.setScene(abnormalOrderListUI.getScene());
	}
	
	public void setTodayUnexecuteOrderView(){
		
		stage.setScene(todayUnexecuteOderUI.getScene());
	}
	
	public void setUnexecuteOrderView(){
		stage.setScene(unexecuteeOrderUI.getScene());
	}
	
	public void setRow(){
		row = todayUnexecuteOderUI.getRow();
	}
	
	public int getRow(){
		return row;
	}
	
}
