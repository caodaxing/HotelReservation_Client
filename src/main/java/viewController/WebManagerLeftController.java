package viewController;

import Message.Identity;
import Message.ResultMessage;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.account.Account;
import logic.hotel.UpdateHotel;
import logic.user.WebManager;
import logic.utility.Encryption;
import logicService.account.AccountService;
import logicService.hotel.UpdateHotelService;
import logicService.stub.AccountService_Stub;
import logicService.stub.HotelService_Stub;
import logicService.stub.WebManagerService_Stub;
import logicService.user.WebManagerService;
import view.helpTools.OneButtonDialog;
import view.right.webManager.hotelInfo.AddHotel;
import view.right.webManager.hotelInfo.AddHotelManager;
import view.right.webManager.hotelManagerInfo.SearchHotelManager;
import view.right.webManager.userInfo.SearchUser;
import view.right.webManager.webBusinessInfo.First;
import vo.AccountVO;
import vo.HotelManagerVO;
import vo.HotelVO;

public class WebManagerLeftController {

	protected Stage stage;
	
	protected String userID;
	
	protected UpdateHotelService updateHotelService ;
	protected WebManagerService webManagerService ;
	protected AccountService accountService ;
	
	protected AddHotel addHotelUI;
	protected AddHotelManager addHotelManagerUI;
	protected SearchHotelManager searchHotelManagerUI;
	protected SearchUser searchUserUI;
	protected First firstUI;
	
	private AccountController accountController;
	
	public WebManagerLeftController(Stage stage , String userID){
		this.stage = stage;
		this.userID = userID;updateHotelService = new UpdateHotel();
		webManagerService = new WebManager();
		accountService = new Account();
		
		addHotelUI = new AddHotel(this);
		addHotelManagerUI = new AddHotelManager(this);
		searchHotelManagerUI = new SearchHotelManager(this);
		searchUserUI = new SearchUser(this);
		firstUI = new First(this);
		
	}
	
	public void setSearchClientView(){
		stage.setScene(searchUserUI.getScene());
	}
	
	public void setSearchHotelManagerView(){
		stage.setScene(searchHotelManagerUI.getScene());
	}
	
	public void setAddHotelView(){
		stage.setScene(addHotelUI.getScene());
	}
	
	public void setAddHotelManagerView(){
		stage.setScene(addHotelManagerUI.getScene());
	}
	//设置酒店工作人员界面
	public void setAddHotelManagerView(String hotelID){
		AddHotelManager addHotelManagerUI = new AddHotelManager(this);
		stage.setScene(addHotelManagerUI.getScene());
	}
	
	public void SearchUserView(){
		stage.setScene(searchUserUI.getScene());
	}
	
	public void setWMWBFirstView(){
		stage.setScene(firstUI.getScene());
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
		//清空id 
		userID = null;
		showDialog("注销成功");
		accountController.setFirstView();
		newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                accountController.logout();
            }
        });
		newStage.setResizable(false);
		newStage.show();
		
	}
	
	public void addHotel(){
		String hotelID = addHotelUI.getHotelID();
		String hotelName = addHotelUI.getHotelName();
		String city = addHotelUI.getCity();
		String area = addHotelUI.getArea();
		if(hotelID.equals("") || hotelName.equals("") || city.equals("") || area.equals("")){
			//信息不完整
			showDialog("请完整填写");
			return ;
		}
		if(hotelID.length()!=5){
			//酒店ID长度不为五位
			showDialog("酒店ID需为五位字母或数字");
			return ;
		}
		
		HotelVO vo = new HotelVO(hotelID, hotelName, city, area, null, 0,  null, null,  null);
		
		ResultMessage result = updateHotelService.addHotel(vo);
		if(result == ResultMessage.SUCCESS){
			//成功，清空textfield,跳入添加酒店工作人员界面
			showDialog("添加成功");
			addHotelUI.setBlank();
		}else{
			//错误
			showDialog("系统错误，请重试");
			return ;
		}
	}
	
	//待修改
	public void addHotelManager(){
		
		String hotelID = addHotelManagerUI.getHotelID();
		String name = addHotelManagerUI.getName();
		String phone = addHotelManagerUI.getPhone();
		String id = addHotelManagerUI.getId();
		String password = addHotelManagerUI.getPassword();
		
		if(hotelID.equals("") || name.equals("") || phone.equals("") || id.equals("") || password.equals("")){
			//信息不完整
			showDialog("请填写完整");
			return ;
		}

		if(hotelID.length()!=5){
			//酒店ID长度不为五位
			showDialog("酒店ID需为五位字母或数字");
			return ;
		}
		
		//查看酒店是否存在
		if(updateHotelService.hotelIDExist(hotelID) == ResultMessage.FAILURE){
			//酒店不存在
			showDialog("酒店不存在，请重新输入");
			return ;
		}
		//查看工作人员是否存在
		if(accountService.userIDExists(hotelID)){
			//已有工作人员
			showDialog("该酒店已有工作人员，请勿重复添加");
			return ;
		}
		//添加工作人员，清空输入框
		HotelManagerVO vo = new HotelManagerVO(hotelID,phone,name,id);
		
		ResultMessage result0 = webManagerService.addHotelManager(vo);
		ResultMessage result1 = accountService.register(Encryption.getInstance().encrypt(new AccountVO(hotelID,password,Identity.HOTELMANAGER)));
		if(result0 == ResultMessage.SUCCESS && result1 == ResultMessage.SUCCESS){
			//成功，清空输入框
			showDialog("添加成功");
			addHotelManagerUI.setBlank();
		}else{
			//失败
			showDialog("添加失败,请重试");
			return ;
		}
		
	}
	
	public String getUserID(){
		return userID;
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
