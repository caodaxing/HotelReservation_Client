package viewController;


import java.util.ArrayList;

import Message.OrderListCondition;
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
import view.right.hotelManager.orderManagement.OrderList;
import view.right.hotelManager.orderManagement.SearchOrder;
import view.right.hotelManager.orderManagement.SetArriveInfo;
import view.right.hotelManager.orderManagement.SetLeaveInfo;
import view.right.hotelManager.orderManagement.UndoOrder;
import view.right.hotelManager.orderManagement.UnexecuteOrder;
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
	private OrderList orderListUI;
	private SearchOrder searchOrderUI;
	private SetArriveInfo setArriveInfoUI;
	private SetLeaveInfo setLeaveInfoUI;
	private UndoOrder undoOrderUI;
	private UnexecuteOrder unexecuteOrderUI;
	
	private int row;
	private ArrayList<OrderVO> orderList;
	
	public HMOrderManagementController(Stage stage, String userId){
		
		//orderService = new Order();
		orderListService = new OrderService_Stub();
		//executeOrderService = new ExecuteOrder();
		//manageOrdreService = new ManageOrder();
		this.stage = stage;
		this.userId = userId;
		abnormalOrderUI = new AbnormalOrder(this);
		checkArriveInfoUI = new CheckArriveInfo(this);
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		evalutionInfoUI = new EvaluationInfo(this);
		executeOrderUI = new ExecuteOrder(this);
//		orderListUI = new OrderList(this);
		searchOrderUI = new SearchOrder(this);
		setArriveInfoUI = new SetArriveInfo(this);
		setLeaveInfoUI = new SetLeaveInfo(this);
		undoOrderUI = new UndoOrder(this);
		unexecuteOrderUI = new UnexecuteOrder(this);
		
	}
	
public HMOrderManagementController(Stage stage, String userId, int row){
		
		//orderService = new Order();
		orderListService = new OrderService_Stub();
		//executeOrderService = new ExecuteOrder();
		//manageOrdreService = new ManageOrder();
		this.stage = stage;
		this.userId = userId;
		this.row = row;
		abnormalOrderUI = new AbnormalOrder(this);
		checkArriveInfoUI = new CheckArriveInfo(this);
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		evalutionInfoUI = new EvaluationInfo(this);
		executeOrderUI = new ExecuteOrder(this);
		orderListUI = new OrderList(this);
		searchOrderUI = new SearchOrder(this);
		setArriveInfoUI = new SetArriveInfo(this);
		setLeaveInfoUI = new SetLeaveInfo(this);
		undoOrderUI = new UndoOrder(this);
		unexecuteOrderUI = new UnexecuteOrder(this);
		
	}
	
	
	public Stage getStage(){
		return stage;
	}
	
	public void setAbnormalOrderView(){
		stage.setScene(abnormalOrderUI.getScene());
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
		stage.setScene(executeOrderUI.getScene());
	}
	
	public void setallOrderListView(){
		stage.setScene(allOrderListUI.getScene());
	}
	
	public void sethasExecuteOrderListView(){
		stage.setScene(hasExecuteOrderListUI.getScene());
	}
	
	public void setunexecuteOrderListView(){
		stage.setScene(unExecuteOrderListUI.getScene());
	}
	
	public void setundoOrderListView(){
		stage.setScene(undoOrderListUI.getScene());
	}
	
	public void setabnormalOrderListView(){
		stage.setScene(abnormalOrderListUI.getScene());
	}
	
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
		stage.setScene(undoOrderUI.getScene());
	}
	
	public void setUnexecuteOrderView(){
		stage.setScene(unexecuteOrderUI.getScene());
	}
	
	public void setRow(){
		row = orderListUI.getRow();
	}
	
	public int getRow(){
		return row;
	}
	
	public void setOrderList(){
		orderList = orderListService.filterHotelOrderList(userId, OrderListCondition.ALL_ORDERS);
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return orderList;
	}
	
}
