package viewController;

import java.util.ArrayList;

import Message.OrderListCondition;
import Message.ResultMessage;
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
import view.right.hotelManager.orderManagement.SearchOrder;
import view.right.hotelManager.promotion.PromotionFirst;
import view.right.hotelManager.roomInfo.First;
import vo.OrderVO;

public class HotelManagerLeftController{
	
	protected ModifyHotelInfo modifyHotelInfoUI;
	protected SearchOrder searchOrderUI;
	protected OrderList orderListUI;
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
	
	public HotelManagerLeftController(){
		
		accountService = new AccountService_Stub();
		orderListService = new OrderService_Stub();
		
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		orderListUI = new OrderList(this);
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
		orderListUI = new OrderList(this);
		orderlist = new ArrayList<OrderVO>();
		orderlist = orderListService.filterHotelOrderList(userId, OrderListCondition.ALL_ORDERS);
		orderListUI.initialData();
		stage.setScene(orderListUI.getScene());
		stage.show();
	}
	
	public void setHasexecuteOrderListView(){
		orderListUI = new OrderList(this);
		orderlist = new ArrayList<OrderVO>();
		orderlist = orderListService.filterHotelOrderList(userId,OrderListCondition.EXECUTED );
		orderListUI.initialData();
		stage.setScene(orderListUI.getScene());
		stage.show();
	}
	
	public void setUnexecuteOrderListView(){
		orderListUI = new OrderList(this);
		orderlist = new ArrayList<OrderVO>();
		orderlist = orderListService.filterHotelOrderList(userId,OrderListCondition.UNEXECUTED );
		orderListUI.initialData();
		stage.setScene(orderListUI.getScene());
		stage.show();
	}
	
	public void setHasUndoOrderListView(){
		orderListUI = new OrderList(this);
		orderlist = new ArrayList<OrderVO>();
		orderlist = orderListService.filterHotelOrderList(userId,OrderListCondition.UNDOED );
		orderListUI.initialData();
		stage.setScene(orderListUI.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderListView(){
		orderListUI = new OrderList(this);
		orderlist = new ArrayList<OrderVO>();
		orderlist = orderListService.filterHotelOrderList(userId,OrderListCondition.ABNORMALED);
		orderListUI.initialData();
		stage.setScene(orderListUI.getScene());
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
	
	public ArrayList<OrderVO> getList(){
		return orderlist;
	}
}
