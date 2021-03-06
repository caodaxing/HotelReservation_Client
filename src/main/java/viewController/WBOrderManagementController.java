package viewController;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.stage.Stage;
import logic.order.ManageOrder;
import logic.order.Order;
import logicService.order.ManageOrderService;
import logicService.order.OrderService;
import view.right.webBusiness.orderManagement.AbnormalOrder;
import view.right.webBusiness.orderManagement.UnexecuteOrder;
import vo.OrderVO;

public class WBOrderManagementController extends WebBusinessLeftController{
	
	//逻辑层接口
	private ManageOrderService manageOrderService;
	private OrderService orderService;
	//控制界面
	private AbnormalOrder abnormalOrderUI;
	protected UnexecuteOrder unexecuteeOrderUI;
//	private int row;
	
	public WBOrderManagementController(Stage stage, String userId){
		//orderService = new Order();
		
		super(stage,userId);
		manageOrderService = new ManageOrder();
		orderService = new Order();
		abnormalOrderUI = new AbnormalOrder(this);
		unexecuteeOrderUI = new UnexecuteOrder(this);
	}
	
//	public WBOrderManagementController(Stage stage, String userId, int row){
//		super(stage,userId);
//		this.row = row;
//		todayUnexecuteOderUI = new TodayUnexecuteOrder(this);
//		unexecuteeOrderUI = new UnexecuteOrder(this);
//		abnormalOrderUI = new AbnormalOrder(this);
//		abnormalOrderListUI = new AbnormalOrderList(this);
//	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setabnormalOrderView(){
		abnormalOrderUI = new AbnormalOrder(this);
		abnormalOrderUI.setText();
		stage.setScene(abnormalOrderUI.getScene());
	}
	
//	public void setAbnormalOrderListView(){
//		stage.setScene(abnormalOrderListUI.getScene());
//	}
	
//	public void setTodayUnexecuteOrderView(){
//		
//		stage.setScene(todayUnexecuteOderUI.getScene());
//	}
	
	public void setUnexecuteOrderView(){
		unexecuteeOrderUI = new UnexecuteOrder(this);
		unexecuteeOrderUI.setText();
		stage.setScene(unexecuteeOrderUI.getScene());
	}
	
//	public void setRow(){
//		row = todayUnexecuteOderUI.getRow();
//	}
	
//	public int getRow(){
//		return row;
//	}
	public ResultMessage getHalfCreditResult(String orderId, boolean bool){
		return manageOrderService.undoAbnormalOrder(orderId, bool);
	}
	
	public OrderVO getOrderVOInfo(){
		return orderService.getOrderInfo(orderId);
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public void setOrderId(int row){
		orderId = orderList.get(row).orderId;
	}
	
	public void setOrderList(ArrayList<OrderVO> orderlist){
		orderList = orderlist;
	}
}
