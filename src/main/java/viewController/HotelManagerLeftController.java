package viewController;

import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.stub.AccountService_Stub;
import view.account.FirstUI;
import view.helpTools.OneButtonDialog;
import view.right.hotelManager.hotelInfo.Blank;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;
import view.right.hotelManager.orderManagement.OrderList;
import view.right.hotelManager.orderManagement.SearchOrder;
import view.right.hotelManager.promotion.PromotionFirst;
import view.right.hotelManager.roomInfo.First;

public class HotelManagerLeftController{
	
	protected ModifyHotelInfo modifyHotelInfoUI;
	protected SearchOrder searchOrderUI;
	protected OrderList orderListUI;
	protected First roomFirstUI;
	protected PromotionFirst promotionFirstUI;
	protected Blank blankUI;
	protected FirstUI firstUI;
	
	protected AccountService accountService;
	
	private AccountController accountController;
	private ResultMessage result;
	
	protected Stage stage;
	protected String userId;
	
	public HotelManagerLeftController(){
		
		accountService = new AccountService_Stub();
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		searchOrderUI = new SearchOrder(this);
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
	
	public void setSearchOrderView(){
		searchOrderUI = new SearchOrder(this);
		stage.setScene(searchOrderUI.getScene());
		stage.show();
	}
	
	public void setOrderListView(){
		orderListUI = new OrderList(this);
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
		
		result = accountService.logout(userId);
		
		if(result == ResultMessage.FAILURE){
			showDialog("注销失败");
			return ;
		}
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
}
