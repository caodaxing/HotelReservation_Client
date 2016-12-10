package viewController;

import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.hotel.UpdateHotelService;
import logicService.stub.HotelManagerService_Stub;
import logicService.stub.HotelService_Stub;
import logicService.stub.WebManagerService_Stub;
import logicService.user.HotelManagerService;
import logicService.user.WebManagerService;
import view.helpTools.OneButtonDialog;
import view.right.webManager.hotelInfo.AddHotel;
import view.right.webManager.hotelInfo.AddHotelManager;
import view.right.webManager.hotelManagerInfo.SearchHotelManager;
import view.right.webManager.userInfo.SearchUser;
import view.right.webManager.webBusinessInfo.First;
import vo.HotelVO;

public class WebManagerLeftController {

	protected Stage stage;
	
	protected String userID;
	
	protected UpdateHotelService updateHotelService ;
	protected WebManagerService webManagerservice ;
	protected AccountService accountService ;	//用时初始化
	
	protected AddHotel addHotelUI;
	protected AddHotelManager addHotelManagerUI;
	protected SearchHotelManager searchHotelManagerUI;
	protected SearchUser searchUserUI;
	protected First firstUI;
	
	private AccountController accountController;
	
	public WebManagerLeftController(){
		updateHotelService = new HotelService_Stub();
		webManagerservice = new WebManagerService_Stub(userID);
		
		addHotelUI = new AddHotel(this);
		addHotelManagerUI = new AddHotelManager(this);
		searchHotelManagerUI = new SearchHotelManager(this);
		searchUserUI = new SearchUser(this);
		firstUI = new First(this);
	}
	
	public WebManagerLeftController(Stage stage , String userID){
		this();
		this.stage = stage;
		this.userID = userID;
	}
	
	public void setSearchHotelManagerView(){
		
	}
	
	public void setAddHotelView(){
		
	}
	
	public void setAddHotelManagerView(){
		
	}
	public void setAddHotelManagerView(String hotelID){
		
	}
	
	public void SearchUserView(){
		
	}
	
	public void setWMWBFirstView(){
		
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
		
		HotelVO vo = new HotelVO(hotelID, hotelName, city, null, area, null, 0, 0, null, null, null, null, null);
		
		ResultMessage result = updateHotelService.addHotel(vo);
		if(result == ResultMessage.SUCCESS){
			//成功，清空textfield,跳入添加酒店工作人员界面
			showDialog("添加成功，请添加酒店工作人员");
			addHotelUI.setBlank();
			setAddHotelManagerView(hotelID);
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
		//查看工作人员是否存在
		//添加工作人员，清空输入框
		//跳入添加酒店界面
		
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
