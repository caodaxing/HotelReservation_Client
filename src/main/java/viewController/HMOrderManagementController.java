package viewController;


import logicService.order.ExecuteOrderService;
import logicService.order.ManageOrderService;
import logicService.order.OrderListService;
import logicService.order.OrderService;
import view.right.hotelManager.orderManagement.AbnormalOrder;
import view.right.hotelManager.orderManagement.CheckArriveInfo;
import view.right.hotelManager.orderManagement.CheckLeaveInfo;
import view.right.hotelManager.orderManagement.EvaluationInfo;
import view.right.hotelManager.orderManagement.ExecuteOrder;
import view.right.hotelManager.orderManagement.OrderList;
import view.right.hotelManager.orderManagement.SearchOrder;
import view.right.hotelManager.orderManagement.SetArriveInfo;
import view.right.hotelManager.orderManagement.SetLeaveInfo;
import view.right.hotelManager.orderManagement.UndoOrder;
import view.right.hotelManager.orderManagement.UnexecuteOrder;

public class HMOrderManagementController {
	
	//逻辑层接口
	private OrderService orderService;
	private OrderListService orderListService;
	private ExecuteOrderService executeOrderService;
	private ManageOrderService manageOrdreService;
	
	//控制的界面
	private AbnormalOrder abnormalOrderUI;
	private CheckArriveInfo checkArriveInfoUI;
	private CheckLeaveInfo checkLeaveInfoUI;
	private EvaluationInfo evalutionInfoUI;
	private ExecuteOrder executeOrderUI;
	private OrderList orderListUI;
	private SearchOrder searchOrderUI;
	private SetArriveInfo setArriveInfoUI;
	private SetLeaveInfo setLeaveInfoUI;
	private UndoOrder undoOrderUI;
	private UnexecuteOrder unexecuteOrderUI;
	
	public HMOrderManagementController(){
		
		//orderService = new Order();
		//orderListService = new OrderList();
		//executeOrderService = new ExecuteOrder();
		//manageOrdreService = new ManageOrder();
	}
	
	public void setView(AbnormalOrder view){
		
		this.abnormalOrderUI = view;
	}
}
