package viewController;

import java.util.ArrayList;

import Message.Identity;
import Message.OrderListCondition;
import Message.ResultMessage;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.account.Account;
import logic.hotel.CheckHotel;
import logic.hotel.UpdateHotel;
import logic.order.Order;
import logic.picture.Picture;
import logic.room.Room;
import logic.utility.Encryption;
import logicService.account.AccountService;
import logicService.hotel.CheckHotelService;
import logicService.hotel.UpdateHotelService;
import logicService.order.OrderListService;
import logicService.order.OrderService;
import logicService.picture.PictureService;
import logicService.room.RoomService;
import view.account.FirstUI;
import view.helpTools.OneButtonDialog;
import view.right.hotelManager.hotelInfo.Blank;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;
import view.right.hotelManager.hotelInfo.ModifyPassword;
import view.right.hotelManager.orderManagement.OrderList;
import view.right.hotelManager.orderManagement.SetArriveInfo;
import view.right.hotelManager.promotion.PromotionFirst;
import view.right.hotelManager.roomInfo.First;
import vo.AccountVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class HotelManagerLeftController{
	
	protected ModifyHotelInfo modifyHotelInfoUI;
	protected SetArriveInfo setArriveInfoUI;
	protected OrderList allOrderListUI;
	protected OrderList hasExecuteOrderListUI;
	protected OrderList unExecuteOrderListUI;
	protected OrderList undoOrderListUI;
	protected OrderList abnormalOrderListUI;
	protected First roomFirstUI;
	protected PromotionFirst promotionFirstUI;
	protected ModifyPassword modifyPasswordUI;
	protected Blank blankUI;
	protected FirstUI firstUI;
	
	protected AccountService accountService;
	protected OrderListService orderListService;
	private OrderService orderService;
	private RoomService roomService;
	private CheckHotelService checkHotelService;
	private PictureService pictureService;
	private UpdateHotelService updateHotelService;
	
	private AccountController accountController;
	
	protected Stage stage;
	protected String userId;
	
	protected ArrayList<OrderVO> orderlist;
	protected String orderId;
	
	public HotelManagerLeftController(Stage stage, String userId){
		
		this.userId = userId;
		this.stage = stage;
		accountService = new Account();
		orderService = new Order();
		orderListService = new logic.order.OrderList();
		roomService = new Room();
		checkHotelService = new CheckHotel();
		pictureService = new Picture();
		updateHotelService = new UpdateHotel();
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		roomFirstUI = new First(this);
		promotionFirstUI = new PromotionFirst(this);
		modifyPasswordUI = new ModifyPassword(this);
		blankUI = new Blank(this);
	}
	
	public void setBlankView(){
		orderId = null;
		blankUI = new Blank(this);
		stage.setScene(blankUI.getScene());
		stage.show();
	}
	
	public void setModifyHotelInfoVeiw(){
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		modifyHotelInfoUI.setHotelInfo();
		stage.setScene(modifyHotelInfoUI.getScene());
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
	
	public void setModifyPasswordView(){
		modifyPasswordUI = new ModifyPassword(this);
		stage.setScene(modifyPasswordUI.getScene());
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
		newStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			 @Override
	         public void handle(WindowEvent event) {
				accountController.logout();
	         }
		});
		newStage.setResizable(false);
		newStage.show();
	}
	
	public void modifyPassword(){
		
		String oldPassword = modifyPasswordUI.getOldPassword();
		String newPassword = modifyPasswordUI.getNewPassword();
		String rePassword = modifyPasswordUI.getRepeatPassword();
		
		if(newPassword.equals("") || rePassword.equals("") || oldPassword.equals("")){
			//有未输入项
			showDialog("请填写完整");
			return ;
		}
		if(!newPassword.equals(rePassword)){
			//两次输入密码不一致
			showDialog("两次输入密码不一致");
			return ;
		}
		
		AccountVO oldVO = new AccountVO(userId,oldPassword ,Identity.CLIENT);
		Encryption.getInstance().encrypt(oldVO);
		if(accountService.canModifyPassword(oldVO)  == ResultMessage.FAILURE){
			//旧密码不正确,弹框清空
			showDialog("原密码错误，请重新输入");
			modifyPasswordUI.setBlank();
			return;
		}
		accountService.logout(userId);
		
		AccountVO vo = new AccountVO(userId, newPassword , Identity.CLIENT );
		ResultMessage result = accountService.modifyPassword(Encryption.getInstance().encrypt(vo));
		 if(result == ResultMessage.FAILURE){
			//未知错误
			showDialog("系统错误，请重试");
		}else if(result == ResultMessage.SUCCESS){
			//修改成功，弹框清空
			showDialog("修改成功");
			modifyPasswordUI.setBlank();
		}
		
	}

//	public Stage getStage(){
//		return stage;
//	}
//
//	//弹出对话框，文字为传入的str
//	public void showDialog(String str){
//		OneButtonDialog dialog = new OneButtonDialog(str);
//		dialog.show();
//	}
	
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
	
	public OrderList getabnormalList(){
		return abnormalOrderListUI;
	}
	
	public HotelVO getHotelVO(String userId){
		return checkHotelService.getHotelnfo(userId);
	}
	
	public ArrayList<Image> getPicture(String userId){
		return pictureService.getHotelImage(userId);
	}
	
	public ResultMessage getUpdaterRoomResult(RoomVO roomVO){
		return roomService.updateRoomInfo(roomVO);
	}
	
	public ResultMessage getUpdateHotelResult(HotelVO hotelVO){
		return updateHotelService.updateHotelInfo(hotelVO);
	}
	
	public ResultMessage savePictureResult(String userId, String imagepath){
		return pictureService.saveHotelImage(userId, imagepath);
	}
	
}
