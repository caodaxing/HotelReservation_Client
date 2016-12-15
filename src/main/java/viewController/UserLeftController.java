package viewController;

import java.util.ArrayList;

import Message.Identity;
import Message.OrderListCondition;
import Message.ResultMessage;
import Message.VipType;
import javafx.stage.Stage;
import logic.utility.Encryption;
import logicService.account.AccountService;
import logicService.order.OrderListService;
import logicService.order.OrderService;
import logicService.stub.AccountService_Stub;
import logicService.stub.ClientService_Stub;
import logicService.stub.OrderService_Stub;
import logicService.user.ClientService;
import view.helpTools.OneButtonDialog;
import view.right.user.VIP.CheckCompanyVIP;
import view.right.user.VIP.CheckNormalVIP;
import view.right.user.VIP.Choose;
import view.right.user.checkHotel.HotelFirst;
import view.right.user.myInfo.CheckMyInfo;
import view.right.user.myOrder.First;
import view.right.user.myOrder.OrderList;
import view.right.user.password.ModifyPassword;
import vo.AccountVO;
import vo.ClientVO;
import vo.OrderVO;
import vo.VipVO;

public class UserLeftController {
	
	protected String userID ;
	
	protected Stage stage;
	
	protected ClientService clientService;
	protected AccountService accountService;
	protected OrderService orderService;
	protected OrderListService orderListService;
	
	private AccountController accountController;
	
	protected Choose chooseUI;
	protected CheckNormalVIP checkNormalVIPUI; 
	protected CheckCompanyVIP checkCompanyVIPUI;
	protected First orderFirstUI;
	//protected OrderList allOrderList;
	//protected OrderList executeOrderList;
	//protected OrderList unexecuteOrderList;
	//protected OrderList undoOrderList;
	//protected OrderList abnormalOrderList;
	protected HotelFirst hotelFirstUI;
	protected ModifyPassword modifyPasswordUI;
	protected CheckMyInfo checkMyInfoUI;
	
	protected String orderID;
	
	protected ArrayList<OrderVO> orderList;
	
	//构造函数
	public UserLeftController(){
		
		accountService = new AccountService_Stub();
		clientService = new ClientService_Stub();
		orderService = new OrderService_Stub();
		orderListService = new OrderService_Stub();

		checkMyInfoUI = new CheckMyInfo(this);
		orderFirstUI = new First(this);
		//allOrderList = new OrderList(this);
		//executeOrderList = new OrderList(this);
		//unexecuteOrderList = new OrderList(this);
		//undoOrderList = new OrderList(this);
		//abnormalOrderList = new OrderList(this);
		hotelFirstUI = new HotelFirst(this);
		modifyPasswordUI = new ModifyPassword(this);
		checkMyInfoUI = new CheckMyInfo(this);
	}
	
	public UserLeftController(Stage stage ,String userID){
		this();
		this.stage = stage ;
		this.userID = userID ;
	}
	
	/*
	 * 选择我的信息，进入查看基本信息界面
	 */
	public void setCheckMyInfoView(){
		checkMyInfoUI = new CheckMyInfo(this);
		checkMyInfoUI.setText();
		stage.setScene(checkMyInfoUI.getScene());
		stage.show();
	}
	
	/*
	 * 选择会员，根据logic层判断显示哪个界面
	 */
	public void setVIPView(){
		//根据是否VIP判断
		boolean isVIP = clientService.isVIP(userID);
		if(isVIP){
			//是VIP显示查看信息界面
			VipVO vo = getVIPInfo();
			//根据VIP种类判断显示哪种查看界面
			if(vo.vipType == VipType.BIRTHDAY_VIP){
				//普通会员
				checkNormalVIPUI = new CheckNormalVIP(this);
				checkNormalVIPUI.setText();
				stage.setScene(checkNormalVIPUI.getScene());
				stage.show();
			}else if(vo.vipType == VipType.BUSINESS_VIP){
				//企业会员
				checkCompanyVIPUI = new CheckCompanyVIP(this);
				checkCompanyVIPUI.setText();
				stage.setScene(checkCompanyVIPUI.getScene());
				stage.show();
			}
		}else{
			//若不是则显示选择注册哪种会员
			chooseUI = new Choose(this);
			stage.setScene(chooseUI.getScene());
			stage.show();
		}
		
	}
	
	/*
	 * 选择我的订单 显示搜索订单页面
	 */
	public void setOrderFirstView(){
		stage.setScene(orderFirstUI.getScene());
		stage.show();
	}
	
	/*
	 * 选择查看酒店，显示选择查看预定过的酒店还是搜索酒店
	 */
	public void setHotelFirstView(){
		stage.setScene(hotelFirstUI.getScene());
		stage.show();
	}

	//设置按条件筛选后的list
	public void setFilterOrderList(OrderListCondition condition){
		orderList = orderListService.filterUserOrderList(userID, condition);
	}
	
	public void setAllOrderList(){
		setFilterOrderList(OrderListCondition.ALL_ORDERS);
		OrderList allOrderList = new OrderList(this);
		allOrderList.setTextValue();
		stage.setScene(allOrderList.getScene());
		stage.show();
	}
	
	public void setExecuteOrderList(){
		setFilterOrderList(OrderListCondition.EXECUTED);
		OrderList executeOrderList = new OrderList(this);
		executeOrderList.setTextValue();
		stage.setScene(executeOrderList.getScene());
		stage.show();
	}
	
	public void setUnexecuteOrderList(){
		setFilterOrderList(OrderListCondition.UNEXECUTED);
		OrderList unexecuteOrderList = new OrderList(this);
		unexecuteOrderList.setTextValue();
		stage.setScene(unexecuteOrderList.getScene());
		stage.show();
	}
	
	public void setUndoOrderList(){
		setFilterOrderList(OrderListCondition.UNDOED);
		OrderList undoOrderList = new OrderList(this);
		undoOrderList.setTextValue();
		stage.setScene(undoOrderList.getScene());
		stage.show();
	}
	
	public void setAbnormalOrderList(){
		setFilterOrderList(OrderListCondition.ABNORMALED);
		OrderList abnormalOrderList = new OrderList(this);
		abnormalOrderList.setTextValue();
		stage.setScene(abnormalOrderList.getScene());
		stage.show();
	}
	
	/*
	 * 修改密码
	 */
	public void setModifyPasswordView(){
		stage.setScene(modifyPasswordUI.getScene());
		stage.show();
	}

	/*
	 * 注销返回首页
	 */
	public void setFirstView(){

		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		
		ResultMessage result = accountService.logout(userID);
		if(result == ResultMessage.FAILURE){
			showDialog("注销失败");
			return ;
		}
		userID = null;
		showDialog("注销成功");
		accountController.setFirstView();
		newStage.setResizable(false);
		newStage.show();
		
	}
	
	/*
	 * 返回VipVO
	 */
	public VipVO getVIPInfo(){
		return clientService.getVipInfo(userID);
	}
	
	/*
	 * 返回clientVO
	 */
	public ClientVO getMyInfo(){
		return clientService.getClientInfo(userID);
	}

	/*
	 * 返回UserID
	 */
	public String getUserID(){
		return userID;
	}

	/*
	 * 返回当前orderList
	 */
	public ArrayList<OrderVO> getOrderList(){
		return orderList;
	}
	
	/*
	 * 返回用户头像路径
	 */
	public String getHeadPath(){
		return clientService.getClientInfo(userID).headImagePath;
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
		
		AccountVO vo = new AccountVO(userID, oldPassword , newPassword , Identity.CLIENT );
		ResultMessage result = accountService.modifyPassword(Encryption.getInstance().encrypt(vo));
		if(result == ResultMessage.UNMATCHED_PASSWORD){
			//旧密码不正确,弹框清空
			showDialog("原密码错误，请重新输入");
			modifyPasswordUI.setBlank();
		}else if(result == ResultMessage.FAILURE){
			//未知错误
			showDialog("系统错误，请重试");
		}else if(result == ResultMessage.SUCCESS){
			//修改成功，弹框清空
			showDialog("修改成功");
			modifyPasswordUI.setBlank();
		}
		
	}

	public Stage getStage(){
		return stage;
	}

	//弹出对话框，文字为传入的str
	public void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
}
