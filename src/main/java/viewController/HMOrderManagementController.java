package viewController;


import java.util.ArrayList;

import Message.OrderState;
import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.order.ExecuteOrderService;
import logicService.order.ManageOrderService;
import logicService.order.OrderListService;
import logicService.order.OrderService;
import logicService.stub.OrderService_Stub;
import view.right.hotelManager.orderManagement.AbnormalOrder;
import view.right.hotelManager.orderManagement.CheckArriveInfo;
import view.right.hotelManager.orderManagement.CheckLeaveInfo;
import view.right.hotelManager.orderManagement.EvaluationInfo;
import view.right.hotelManager.orderManagement.ExecuteOrder;
import view.right.hotelManager.orderManagement.SearchOrder;
import view.right.hotelManager.orderManagement.SetArriveInfo;
import view.right.hotelManager.orderManagement.SetLeaveInfo;
import view.right.hotelManager.orderManagement.UndoOrder;
import view.right.hotelManager.orderManagement.UnexecuteOrder;
import vo.EvaluationVO;
import vo.OrderVO;

public class HMOrderManagementController extends HotelManagerLeftController{
	
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
	private SearchOrder searchOrderUI;
	private SetArriveInfo setArriveInfoUI;
	private SetLeaveInfo setLeaveInfoUI;
	private UndoOrder undoOrderUI;
	private UnexecuteOrder unexecuteOrderUI;
	
//	private ArrayList<OrderVO> orderList;
	
	public HMOrderManagementController(Stage stage, String userId){
		
		orderService = new OrderService_Stub();
		orderListService = new OrderService_Stub();
		executeOrderService = new OrderService_Stub();
		//manageOrdreService = new ManageOrder();
		this.stage = stage;
		this.userId = userId;
//		abnormalOrderUI = new AbnormalOrder(this);
		checkArriveInfoUI = new CheckArriveInfo(this);
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		evalutionInfoUI = new EvaluationInfo(this);
//		executeOrderUI = new ExecuteOrder(this);
//		orderListUI = new OrderList(this);
		searchOrderUI = new SearchOrder(this);
		setArriveInfoUI = new SetArriveInfo(this);
		setLeaveInfoUI = new SetLeaveInfo(this);
//		undoOrderUI = new UndoOrder(this);
//		unexecuteOrderUI = new UnexecuteOrder(this);
		
	}
	
//public HMOrderManagementController(Stage stage, String userId, int row){
//		
//		//orderService = new Order();
//		orderListService = new OrderService_Stub();
//		executeOrderService = new OrderService_Stub();
//		//manageOrdreService = new ManageOrder();
//		this.stage = stage;
//		this.userId = userId;
//		this.row = row;
//		abnormalOrderUI = new AbnormalOrder(this);
//		checkArriveInfoUI = new CheckArriveInfo(this);
//		checkLeaveInfoUI = new CheckLeaveInfo(this);
//		evalutionInfoUI = new EvaluationInfo(this);
//		executeOrderUI = new ExecuteOrder(this);
////		orderListUI = new OrderList(this);
//		searchOrderUI = new SearchOrder(this);
//		setArriveInfoUI = new SetArriveInfo(this);
//		setLeaveInfoUI = new SetLeaveInfo(this);
//		undoOrderUI = new UndoOrder(this);
//		unexecuteOrderUI = new UnexecuteOrder(this);
//		
//	}
	
	
	public Stage getStage(){
		return stage;
	}
	
	public void setAbnormalOrderView(){
		abnormalOrderUI = new AbnormalOrder(this);
		stage.setScene(abnormalOrderUI.getScene());
		abnormalOrderUI.setText();
	}
	
	public void setCheckArriveInfoView(){
		stage.setScene(checkArriveInfoUI.getScene());
	}
	
	public void setCheckLeaveInfoView(){
		stage.setScene(checkLeaveInfoUI.getScene());
	}
	
	public void setEvaluationInfoView(){
		stage.setScene(evalutionInfoUI.getScene());
		
	}
	
	public void setExecuteOrderView(){
		executeOrderUI = new ExecuteOrder(this);
		stage.setScene(executeOrderUI.getScene());
		executeOrderUI.setText();
	}
	
//	public void setallOrderListView(){
//		setfilterOrderList(OrderListCondition.ALL_ORDERS);
//		OrderList allOrderListUI = new OrderList(this);
//		allOrderListUI.InitialData();
//		stage.setScene(allOrderListUI.getScene());
//		stage.show();
//	}
	
//	public void sethasExecuteOrderListView(){
//		setfilterOrderList(OrderListCondition.EXECUTED);
//		OrderList hasExecuteOrderListUI = new OrderList(this);
//		hasExecuteOrderListUI.InitialData();
//		stage.setScene(hasExecuteOrderListUI.getScene());
//		stage.show();
//	}
	
//	public void setunexecuteOrderListView(){
//		setfilterOrderList(OrderListCondition.UNEXECUTED);
//		OrderList unExecuteOrderListUI = new OrderList(this);
//		unExecuteOrderListUI.InitialData();
//		stage.setScene(unExecuteOrderListUI.getScene());
//		stage.show();
//	}
	
//	public void setundoOrderListView(){
//		setfilterOrderList(OrderListCondition.UNDO_UNEXECUTED);
//		OrderList undoOrderListUI = new OrderList(this);
//		undoOrderListUI.InitialData();
//		stage.setScene(undoOrderListUI.getScene());
//		stage.show();
//	}
	
//	public void setabnormalOrderListView(){
//		setfilterOrderList(OrderListCondition.ABNORMALED);
//		OrderList abnormalOrderListUI = new OrderList(this);
//		abnormalOrderListUI.InitialData();
//		stage.setScene(abnormalOrderListUI.getScene());
//		stage.show();
//	}
	
	public void setSearchOrderView(){
		stage.setScene(searchOrderUI.getScene());
	}
	
	public void setSetArriveInfoView(){
		stage.setScene(setArriveInfoUI.getScene());
	}
	
	public void setSetLeaveInfoView(){
		stage.setScene(setLeaveInfoUI.getScene());
	}
	
	public void setUndoOrderView(){
		undoOrderUI = new UndoOrder(this);
		stage.setScene(undoOrderUI.getScene());
		undoOrderUI.setText();
	}
	
	public void setUnexecuteOrderView(){
		unexecuteOrderUI = new UnexecuteOrder(this);
		stage.setScene(unexecuteOrderUI.getScene());
		unexecuteOrderUI.setText();
	}
	
//	public void setRow(){
//		row = orderListUI.getRow();
//	}
//	
//	public int getRow(){
//		return row;
//	}
	
	
//	public ArrayList<OrderVO> getOrderList(){
//		return orderList;
//	}
	
//	public void setfilterOrderList(OrderListCondition condition){
//		orderList = orderListService.filterHotelOrderList(userId, condition);
//	}
	
	public OrderVO getOrderInfo(){
		return orderService.getOrderInfo(orderId);
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public void setOrderId(int row){
		orderId = orderlist.get(row).orderId;
	}
	
	public void setOrderList(ArrayList<OrderVO> orderList){
		orderlist = orderList;
	}
	
	public void setOrderView() {
		OrderState state = orderService.getOrderInfo(orderId).orderState;
//		System.out.println(orderId);
		if(state == OrderState.ABNORMAL){
			setAbnormalOrderView();
		}else if(state == OrderState.EXECUTED){
			setExecuteOrderView();
		}else if(state == OrderState.UNDOED_ABNORMAL || state == OrderState.UNDOED_UNEXECUTED){
			setUndoOrderView();
		}else if(state == OrderState.UNEXECUTED){
			setUnexecuteOrderView();
		}else{
			showDialog("系统错误，请重试");
			return;
		}
	}
	
	public ResultMessage getResult(String orderID, String[] roomId){
		return executeOrderService.normalExecute(orderID, roomId);
	}
	
//	public ResultMessage getLeaveResult(String orderID){
//		return executeOrderService.hasCheckOut(orderID);
//	}
	
	public ResultMessage setLeaveResult(String orderId){
		return executeOrderService.checkOut(orderId);
	}
	
	public EvaluationVO getEvaluation(String orderId){
		return orderService.getEvaluationInfo(orderId);
	}
}
