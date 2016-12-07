package viewController;

import javafx.stage.Stage;
import logicService.order.ManageOrderService;
import logicService.order.OrderService;
import view.right.webBusiness.orderManagement.AbnormalOrder;
import view.right.webBusiness.orderManagement.AbnormalOrderList;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder;
import view.right.webBusiness.orderManagement.UnexecuteOrder;

public class WBOrderManagementController {
	
	private Stage stage;
	
	//逻辑层接口
	private OrderService orderService;
	private ManageOrderService manageOrderService;
	
	//控制界面
	private AbnormalOrder abnormalOrderUI;
	private AbnormalOrderList abnormalOrderListUI;
	private TodayUnexecuteOrder todayUnexecuteOderUI;
	private UnexecuteOrder unexecuteeOrderUI;
	
	public WBOrderManagementController(Stage stage){
		//orderService = new Order();
		//manageOrderService = new ManageOrder();
		this.stage = stage;
		abnormalOrderUI = new AbnormalOrder(this);
		abnormalOrderListUI = new AbnormalOrderList(this);
		todayUnexecuteOderUI = new TodayUnexecuteOrder(this);
		unexecuteeOrderUI = new UnexecuteOrder(this);
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setAbnormalOrderView(){
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
}
