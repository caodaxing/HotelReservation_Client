package viewController;


import java.util.ArrayList;

import Message.OrderState;
import Message.ResultMessage;
import javafx.stage.Stage;
import logic.order.Order;
import logicService.order.ExecuteOrderService;
import logicService.order.OrderService;
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
	private ExecuteOrderService executeOrderService;
	
	//控制的界面
	private AbnormalOrder abnormalOrderUI;
	private CheckArriveInfo checkArriveInfoUI;
	private CheckLeaveInfo checkLeaveInfoUI;
	private EvaluationInfo evalutionInfoUI;
	private ExecuteOrder executeOrderUI;
	private SearchOrder searchOrderUI;
//	private SetArriveInfo setArriveInfoUI;
	private SetLeaveInfo setLeaveInfoUI;
	private UndoOrder undoOrderUI;
	private UnexecuteOrder unexecuteOrderUI;
	
//	private ArrayList<OrderVO> orderList;
	
	public HMOrderManagementController(Stage stage, String userId){
		
		super(stage,userId);
		//manageOrdreService = new ManageOrder();
		this.stage = stage;
		this.userId = userId;
//		abnormalOrderUI = new AbnormalOrder(this);
		orderService = new Order();
		executeOrderService = new logic.order.ExecuteOrder();
		checkArriveInfoUI = new CheckArriveInfo(this);
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		evalutionInfoUI = new EvaluationInfo(this);
		executeOrderUI = new ExecuteOrder(this);
//		orderListUI = new OrderList(this);
		searchOrderUI = new SearchOrder(this);
//		setArriveInfoUI = new SetArriveInfo(this);
		setLeaveInfoUI = new SetLeaveInfo(this);
//		undoOrderUI = new UndoOrder(this);
//		unexecuteOrderUI = new UnexecuteOrder(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setAbnormalOrderView(){
		abnormalOrderUI = new AbnormalOrder(this);
		abnormalOrderUI.setText();
		stage.setScene(abnormalOrderUI.getScene());
	}
	
	public void setCheckArriveInfoView(){
		checkArriveInfoUI = new CheckArriveInfo(this);
System.out.println("     "+ orderId);
		checkArriveInfoUI.setText();
		stage.setScene(checkArriveInfoUI.getScene());
	}
	
	public void setCheckLeaveInfoView(){
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		checkLeaveInfoUI.setText();
		stage.setScene(checkLeaveInfoUI.getScene());
	}
	
	public void setEvaluationInfoView(){
		evalutionInfoUI = new EvaluationInfo(this);
		evalutionInfoUI.setText();
		stage.setScene(evalutionInfoUI.getScene());
		
	}
	
	public void setExecuteOrderView(){
//		executeOrderUI = new ExecuteOrder(this);
		executeOrderUI.setText();
		stage.setScene(executeOrderUI.getScene());
	}
	
	
	public void setSearchOrderView(){
		
		stage.setScene(searchOrderUI.getScene());
	}
	
//	public void setSetArriveInfoView(){
//		stage.setScene(setArriveInfoUI.getScene());
//	}
	
	public void setSetLeaveInfoView(){
		stage.setScene(setLeaveInfoUI.getScene());
	}
	
	public void setUndoOrderView(){
		undoOrderUI = new UndoOrder(this);
		undoOrderUI.setText();
		stage.setScene(undoOrderUI.getScene());
	}
	
	public void setUnexecuteOrderView(){
		unexecuteOrderUI = new UnexecuteOrder(this);
		unexecuteOrderUI.setText();
		stage.setScene(unexecuteOrderUI.getScene());
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
	
//	public OrderVO getOrderInfo(){
//		return orderService.getOrderInfo(orderId);
//	}
//	
//	public void setOrderId(String orderId){
//		this.orderId = orderId;
//	}
//	
//	public void setOrderId(int row){
//		this.orderId = orderlist.get(row).orderId;
//	}
//	
//	public void setOrderList(ArrayList<OrderVO> orderList){
//		orderlist = orderList;
//	}
	
	public void setOrderView() {
System.out.println(orderId);
		OrderState state = orderService.getOrderInfo(orderId).orderState;
System.out.println(state);
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
	
	
	
	public ResultMessage getLeaveResult(){
		return executeOrderService.hasCheckOut(orderId);
	}
	
	public ResultMessage setLeaveResult(){
		return executeOrderService.checkOut(orderId);
	}
	
	public EvaluationVO getEvaluation(String orderId){
		return orderService.getEvaluationInfo(orderId);
	}
	
	public ResultMessage getRoomInfoUpdateResult(String orderId, String[] roomID){
		return executeOrderService.normalExecute(orderId, roomID);
	}
	
	public ResultMessage getSupplyOrderResult(String orderId, String[] roomID){
		return executeOrderService.supplyOrder(orderId, roomID);
	}
	
	public OrderVO getOrder(String orderID){
		return orderService.getOrderInfo(orderID);
	}
	
	public OrderVO getOrderInfo(){
		System.out.println(orderId);
		return orderService.getOrderInfo(orderId);
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
			
	public void setOrderId(int row){
		orderId = orderlist.get(row).orderId;
		System.out.println(orderId);
	}
	
	public void setOrderList(ArrayList<OrderVO> orderList){
		orderlist = orderList;
	}
	
	public String getOrderId(){
		return orderId;
	}
	
	public void setReturnExecuteOrderView(){
//		executeOrderUI = new ExecuteOrder(this);
		stage.setScene(executeOrderUI.getScene());
	}
}
