package viewController;

import java.util.ArrayList;

import Message.ResultMessage;
import Message.VipType;
import javafx.stage.Stage;
import logicService.account.AccountService;
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
import vo.ClientVO;
import vo.OrderVO;
import vo.VipVO;

public class UserLeftController {
	
	protected String userID ;
	
	protected Stage stage;
	
	private ClientService clientService;
	private AccountService accountService;
	
	private AccountController accountController;
	
	protected Choose chooseUI;
	protected CheckNormalVIP checkNormalVIPUI; 
	protected CheckCompanyVIP checkCompanyVIPUI;
	protected First orderFirstUI;
	protected OrderList allOrderList;
	protected OrderList executeOrderList;
	protected OrderList unexecuteOrderList;
	protected OrderList undoOrderList;
	protected OrderList abnormalOrderList;
	protected HotelFirst hotelFirstUI;
	protected ModifyPassword modifyPasswordUI;
	protected CheckMyInfo checkMyInfoUI;
	
	//构造函数
	public UserLeftController(){
	
	}
	public UserLeftController(Stage stage ,String userID){
		this.stage = stage ;
		this.userID = userID ;
	}
	
	/*
	 * 选择我的信息，进入查看基本信息界面
	 */
	public void setCheckMyInfoView(){
		checkMyInfoUI = new CheckMyInfo(this);
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
				stage.setScene(checkNormalVIPUI.getScene());
				stage.show();
			}else if(vo.vipType == VipType.BUSINESS_VIP){
				//企业会员
				checkCompanyVIPUI = new CheckCompanyVIP(this);
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
		orderFirstUI = new First(this);
		stage.setScene(orderFirstUI.getScene());
		stage.show();
	}
	
	/*
	 * 选择查看酒店，显示选择查看预定过的酒店还是搜索酒店
	 */
	public void setHotelFirstView(){
		hotelFirstUI = new HotelFirst(this);
		stage.setScene(hotelFirstUI.getScene());
		stage.show();
	}
	
	//待修改
	public void setAllOrderList(){
		allOrderList = new OrderList(this);
		stage.setScene(allOrderList.getScene());
		stage.show();
	}
	
	//待修改
	public void setExecuteOrderList(){
		executeOrderList = new OrderList(this);
		stage.setScene(executeOrderList.getScene());
		stage.show();
	}
	
	//待修改		
	public void setUnexecuteOrderList(){
		unexecuteOrderList = new OrderList(this);
		stage.setScene(unexecuteOrderList.getScene());
		stage.show();
	}
	
	//待修改
	public void setUndoOrderList(){
		undoOrderList = new OrderList(this);
		stage.setScene(undoOrderList.getScene());
		stage.show();
	}
	
	//待修改
	public void setAbnormalOrderList(){
		abnormalOrderList = new OrderList(this);
		stage.setScene(abnormalOrderList.getScene());
		stage.show();
	}
	
	/*
	 * 修改密码
	 */
	public void setModifyPasswordView(){
		modifyPasswordUI = new ModifyPassword(this);
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
		showDialog("注销成功");
		accountController.setFirstView();
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
	
	//各种getlist方法，加个根据list生成不同列表的方法。待填充
	public ArrayList<OrderVO> getAllOrderList(){
		return null;
	}

	public Stage getStage(){
		return stage;
	}

	//弹出对话框，文字为传入的str
	protected void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
}
