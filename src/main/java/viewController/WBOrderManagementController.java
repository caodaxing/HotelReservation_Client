package viewController;

import logic.orderManagement.ManageOrder;
import logicService.order.OrderService;
import logicService.orderManagement.ManageOrderService;
import view.right.webBusiness.orderManagement.AbnormalOrder;
import view.right.webBusiness.orderManagement.AbnormalOrderList;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder;
import view.right.webBusiness.orderManagement.UnexecuteOrder;

public class WBOrderManagementController {
	
	//逻辑层接口
	private OrderService orderService;
	private ManageOrderService manageOrderService;
	
	//控制界面
	private AbnormalOrder abnormalOrderUI;
	private AbnormalOrderList abnormalOrderListUI;
	private TodayUnexecuteOrder todayUnexecuteOderUI;
	private UnexecuteOrder unexecuteeOrderUI;
	
	public WBOrderManagementController(){
		//orderService = new Order();
		//manageOrderService = new ManageOrder();
	}
	
	public void setView(UnexecuteOrder view){
		this.unexecuteeOrderUI = view;
	}
}
