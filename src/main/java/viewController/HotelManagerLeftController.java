package viewController;

import java.util.ArrayList;

import Message.OrderListCondition;
import Message.ResultMessage;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.account.Account;
import logic.order.Order;
import logic.room.Room;
import logicService.account.AccountService;
import logicService.order.OrderListService;
import logicService.order.OrderService;
import logicService.room.RoomService;
import view.account.FirstUI;
import view.helpTools.OneButtonDialog;
import view.right.hotelManager.hotelInfo.Blank;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;
import view.right.hotelManager.orderManagement.OrderList;
import view.right.hotelManager.orderManagement.SetArriveInfo;
import view.right.hotelManager.promotion.PromotionFirst;
import view.right.hotelManager.roomInfo.First;
import vo.OrderVO;
import vo.RoomVO;

public class HotelManagerLeftController{
	
	protected ModifyHotelInfo modifyHotelInfoUI;
	private SetArriveInfo setArriveInfoUI;
	protected OrderList allOrderListUI;
	protected OrderList hasExecuteOrderListUI;
	protected OrderList unExecuteOrderListUI;
	protected OrderList undoOrderListUI;
	protected OrderList abnormalOrderListUI;
	protected First roomFirstUI;
	protected PromotionFirst promotionFirstUI;
	protected Blank blankUI;
	protected FirstUI firstUI;
	
	protected AccountService accountService;
	protected OrderListService orderListService;
	private OrderService orderService;
	private RoomService roomService;
	
	private AccountController accountController;
	
	protected Stage stage;
	protected String userId;
	
	protected ArrayList<OrderVO> orderlist;
	protected String orderId;
	
	public HotelManagerLeftController(){
		
		accountService = new Account();
		orderService = new Order();
		orderListService = new logic.order.OrderList();
		roomService = new Room();
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		setArriveInfoUI = new SetArriveInfo(this);
//		allOrderListUI = new OrderList(this);
//		hasExecuteOrderListUI = new OrderList(this);
//		unExecuteOrderListUI = new OrderList(this);
//		undoOrderListUI = new OrderList(this);
//		abnormalOrderListUI = new OrderList(this);
		roomFirstUI = new First(this);
		promotionFirstUI = new PromotionFirst(this);
		blankUI = new Blank(this);
		
	}
	
	public HotelManagerLeftController(Stage stage, String userId){
		this();
		this.userId = userId;
		this.stage = stage;
	}
	
	public void setBlankView(){
		blankUI = new Blank(this);
		stage.setScene(blankUI.getScene());
		stage.show();
	}
	
	public void setModifyHotelInfoVeiw(){
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		stage.setScene(modifyHotelInfoUI.getScene());
		stage.show();
	}
	
	public void setSetArriveInfoView(){
		setArriveInfoUI = new SetArriveInfo(this);
		stage.setScene(setArriveInfoUI.getScene());
		stage.show();
	}
	
	
	
	//设置列表筛选
	public void setFilterOrderList(OrderListCondition condition){
		orderlist = orderListService.filterHotelOrderList(userId, condition);
	}
	
	public void setAllOrderListView(){
		orderId = null;
		setFilterOrderList(OrderListCondition.ALL_ORDERS);
		OrderList allOrderListUI = new OrderList(this);
		allOrderListUI.initialData();
		stage.setScene(allOrderListUI.getScene());
		stage.show();
	}
	
	public void setHasExecuteOrderListView(){
		orderId = null;
		setFilterOrderList(OrderListCondition.EXECUTED);
		OrderList hasExecuteOrderListUI = new OrderList(this);
		hasExecuteOrderListUI.initialData();
		stage.setScene(hasExecuteOrderListUI.getScene());
		stage.show();
	}
	
	public void setunExecuteOrderListView(){
		orderId = null;
		setFilterOrderList(OrderListCondition.UNEXECUTED);
		OrderList unExecuteOrderListUI = new OrderList(this);
		unExecuteOrderListUI.initialData();
		stage.setScene(unExecuteOrderListUI.getScene());
		stage.show();
	}
	
	public void setUndoOrderListView(){
		orderId = null;
		setFilterOrderList(OrderListCondition.UNDO_UNEXECUTED);
		OrderList undoOrderListUI = new OrderList(this);
		undoOrderListUI.initialData();
		stage.setScene(undoOrderListUI.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderListView(){
		orderId = null;
		setFilterOrderList(OrderListCondition.ABNORMALED);
		OrderList abnormalOrderListUI = new OrderList(this);
		abnormalOrderListUI.initialData();
		stage.setScene(abnormalOrderListUI.getScene());
		stage.show();
	}
	
	
	public void setRoomFirstView(){
		First roomFirstUI = new First(this);
		stage.setScene(roomFirstUI.getScene());
		stage.show();
	}
	
	public void setPromotionFirstView(){
		promotionFirstUI = new PromotionFirst(this);
		stage.setScene(promotionFirstUI.getScene());
		stage.show();
	}
	
	public void setFirstUIView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		
		ResultMessage result = accountService.logout(userId);
		if(result == ResultMessage.FAILURE){
			showDialog("注销失败");
			return ;
		}
		userId = null;
		showDialog("注销成功");
		newStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			 @Override
	         public void handle(WindowEvent event) {
				 ResultMessage result = accountService.logout(userId);
					if(result == ResultMessage.FAILURE){
						showDialog("注销失败");
						return ;
					}
					userId = null;
					showDialog("注销成功");
	         }
		});
		accountController.setFirstView();
		newStage.show();
	}
	
	//返回提示框
	public void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
	//返回userId
	public String getUserId(){
		return userId;
	}
	
	//返回当前orderList
	public ArrayList<OrderVO> getlist(){
		return orderlist;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public String getOrderId(){
		return orderId;
	}
	
	
	
	public OrderList getabnormalList(){
		return abnormalOrderListUI;
	}
//	
//	public OrderVO getOrder(){
//		return orderlist.get(row);
//	}
//	
//	public void setRow(OrderListCondition condition){
//		if(condition == OrderListCondition.ABNORMALED){
//			OrderList abnormalOrderListUI = new OrderList(this);
//			row = abnormalOrderListUI.getRow();
//		}else if(condition == OrderListCondition.EXECUTED){
//			
//		}else if(condition == OrderListCondition.UNEXECUTED){
//			
//		}else if(condition == OrderListCondition.UNDO_UNEXECUTED){
//			
//		}else{
//			
//		}
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
	
	public ResultMessage getUpdaterRoomResult(RoomVO roomVO){
		return roomService.updateRoomInfo(roomVO);
	}
	
}
