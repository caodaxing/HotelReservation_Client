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
	private int label = -1;
	
	public HotelManagerLeftController(){
		
		accountService = new AccountService_Stub();
		orderListService = new OrderService_Stub();
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		allOrderListUI = new OrderList(this);
		hasExecuteOrderListUI = new OrderList(this);
		unExecuteOrderListUI = new OrderList(this);
		undoOrderListUI = new OrderList(this);
		abnormalOrderListUI = new OrderList(this);
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
		label = 0;
		stage.setScene(allOrderListUI.getScene());
		stage.show();
	}
	
	public void setHasExecuteOrderListView(){
		label = 1;
		stage.setScene(hasExecuteOrderListUI.getScene());
		stage.show();
	}
	
	public void setunExecuteOrderListView(){
		label = 2;
		stage.setScene(unExecuteOrderListUI.getScene());
		stage.show();
	}
	
	public void setUndoOrderListView(){
		label = 3;
		stage.setScene(undoOrderListUI.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderListView(){
		label = 4;
		stage.setScene(abnormalOrderListUI.getScene());
		stage.show();
	}
	
	
	public void setRoomFirstView(){
		roomFirstUI = new First(this);
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
	
	public void setList(int label){
		if(label == 0){
			orderlist = orderListService.filterHotelOrderList(userId, OrderListCondition.ALL_ORDERS);
		}else if(label == 1){
			orderlist = orderListService.filterHotelOrderList(userId, OrderListCondition.EXECUTED);
		}else if(label == 2){
			orderlist = orderListService.filterHotelOrderList(userId, OrderListCondition.UNEXECUTED);
		}else if(label == 3){
			orderlist = orderListService.filterHotelOrderList(userId, OrderListCondition.UNDOED);
		}else{
			orderlist = orderListService.filterHotelOrderList(userId, OrderListCondition.ABNORMALED);
		}
	}
	
	public int getLabel(){
		return label;
	}
	
	public ArrayList<OrderVO> getlist(){
		return orderlist;
	}
}
