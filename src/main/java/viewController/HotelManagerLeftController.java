package viewController;

import java.util.ArrayList;

import Message.OrderListCondition;
import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.order.OrderListService;
import logicService.stub.AccountService_Stub;
import logicService.stub.OrderService_Stub;
import view.account.FirstUI;
import view.helpTools.OneButtonDialog;
import view.right.hotelManager.hotelInfo.Blank;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;
import view.right.hotelManager.orderManagement.OrderList;
import view.right.hotelManager.promotion.PromotionFirst;
import view.right.hotelManager.roomInfo.First;
import vo.OrderVO;

public class HotelManagerLeftController{
	
	protected ModifyHotelInfo modifyHotelInfoUI;
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
	
	private AccountController accountController;
	private ResultMessage result;
	
	protected Stage stage;
	protected String userId;
	
	private ArrayList<OrderVO> orderlist;
	private int row;
	
	public HotelManagerLeftController(){
		
		accountService = new AccountService_Stub();
		orderListService = new OrderService_Stub();
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
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
	
	public void setAllOrderListView(){
		setFilterOrderList(OrderListCondition.ALL_ORDERS);
		OrderList allOrderListUI = new OrderList(this);
		allOrderListUI.initialData();
		stage.setScene(allOrderListUI.getScene());
		stage.show();
	}
	
	public void setHasExecuteOrderListView(){
		setFilterOrderList(OrderListCondition.EXECUTED);
		OrderList hasExecuteOrderListUI = new OrderList(this);
		hasExecuteOrderListUI.initialData();
		stage.setScene(hasExecuteOrderListUI.getScene());
		stage.show();
	}
	
	public void setunExecuteOrderListView(){
		setFilterOrderList(OrderListCondition.UNEXECUTED);
		OrderList unExecuteOrderListUI = new OrderList(this);
		unExecuteOrderListUI.initialData();
		stage.setScene(unExecuteOrderListUI.getScene());
		stage.show();
	}
	
	public void setUndoOrderListView(){
		setFilterOrderList(OrderListCondition.UNDO_UNEXECUTED);
		OrderList undoOrderListUI = new OrderList(this);
		undoOrderListUI.initialData();
		stage.setScene(undoOrderListUI.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderListView(){
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
		accountController.setFirstView();
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
	
	public void setFilterOrderList(OrderListCondition condition){
		orderlist = orderListService.filterHotelOrderList(userId, condition);
	}
	
	public ArrayList<OrderVO> getlist(){
		return orderlist;
	}
	
	public OrderList getabnormalList(){
		return abnormalOrderListUI;
	}
	
	public OrderVO getOrder(){
		return orderlist.get(row);
	}
	
	public void setRow(OrderListCondition condition){
		if(condition == OrderListCondition.ABNORMALED){
			OrderList abnormalOrderListUI = new OrderList(this);
			row = abnormalOrderListUI.getRow();
		}else if(condition == OrderListCondition.EXECUTED){
			
		}else if(condition == OrderListCondition.UNEXECUTED){
			
		}else if(condition == OrderListCondition.UNDO_UNEXECUTED){
			
		}else{
			
		}
	}
}
