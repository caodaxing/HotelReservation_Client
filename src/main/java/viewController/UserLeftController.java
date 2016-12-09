package viewController;

import Message.ResultMessage;
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

public class UserLeftController {
	
	protected String userID ;
	
	protected Stage stage;
	
	private ClientService clientService;
	private AccountService accountService;
	
	private AccountController accountController;
	
	protected Choose chooseUI;
	protected CheckNormalVIP checkNormalVIPUI; 
	protected CheckCompanyVIP checkCompanyVIPUI;
	protected First firstUI;
	protected OrderList allOrderList;
	protected OrderList executeOrderList;
	protected OrderList unexecuteOrderList;
	protected OrderList undoOrderList;
	protected OrderList abnormalOrderList;
	protected HotelFirst hotelFirstUI;
	protected ModifyPassword modifyPasswordUI;
	protected CheckMyInfo checkMyInfoUI;
	
	public UserLeftController(){
	
	}
	
	public void setCheckMyInfoView(){
		
	}
	
	public void setVIPView(){
		
	}
	
	public void setOrderFirstView(){
		
	}
	
	public void setHotelFirstView(){
		
	}
	
	public void setAllOrderList(){
		
	}
	
	public void setExecuteOrderList(){
		
	}
	
	public void setUnexecuteOrderList(){
		
	}
	
	public void setUndoOrderList(){
		
	}
	
	public void setAbnormalOrderList(){
		
	}
	
	public void setModifyPasswordView(){
		modifyPasswordUI = new ModifyPassword(this);
	}

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
	

	//弹出对话框，文字为传入的str
	protected void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
	
}
