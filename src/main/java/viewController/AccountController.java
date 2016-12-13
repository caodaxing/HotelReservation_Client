package viewController;

import Message.Identity;
import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.stub.AccountService_Stub;
import view.account.FirstUI;
import view.account.SignInUI;
import view.account.SignUpUI;
import view.helpTools.OneButtonDialog;
import vo.AccountVO;

public class AccountController {

	//stage
	private Stage stage ;
	
	//逻辑层接口
	private AccountService accountService ; 
	
	//同层controller
	private UserMyInfoController userController ;//需用userID初始化
	private VistorController vistorController ;
	private WMUserInfoController webManagerController ;
	private WBVIPInfoController wbVIPInfoController;
	private HMHotelInfoController hmOrderManagementController;
	//差两个
	
	//管理的页面
	private FirstUI firstUI ;
	private SignInUI signInUI ;
	private SignUpUI signUpUI ;
	
	public AccountController(Stage stage){
		
		this.stage = stage;
		
		accountService = new AccountService_Stub();
		
		firstUI = new FirstUI(this);
		signInUI = new SignInUI(this);
		signUpUI = new SignUpUI(this);
		
	}
	
	public Stage getStage(){
		
		return stage ;
		
	}
	
	public void setFirstView(){
		
		stage.setScene(firstUI.getScene());
	
	}
	
	public void setSignInView(){
		
		stage.setScene(signInUI.getScene());
	
	}
	
	public void setSignUpView(){
		
		stage.setScene(signUpUI.getScene());
	
	}
	
	public void setVistorBlankView(){
		vistorController = new VistorController(stage);
		vistorController.setSearchHotelView();
	}
	
	public void register(){
		
		String userID = signUpUI.getID();
		String password = signUpUI.getPassword();
		String rePassword = signUpUI.getRePassword();

		if(userID.equals("")){
			//用户名为空，弹出“请输入用户名”
			showDialog("请输入用户名");
		}
		else if(password.equals("")){
			//密码域为空，弹出“请输入密码”
			showDialog("请输入密码");
		}
		else if(userID.length()>12 || userID.length()<6){
			//用户名不符合格式，弹出“用户名请用6-12位字母和数字组合”对话框
			showDialog("用户名请使用6-12位数字和字母组合");
			
		}else if(!password.equals(rePassword)){
			//两次输入密码不一致，弹出“两次密码输入不一致，请重新输入”
			showDialog("两次密码输入不一致，请重新输入");
		}else if(accountService.userIDExists(userID)){
			//用户名已存在
			showDialog("用户名已存在");
		}else{
			
			AccountVO accountVO = new AccountVO(userID,password,Identity.CLIENT);
			ResultMessage result = accountService.register(accountVO);
		
			if(result == ResultMessage.SUCCESS){//注册成功则返回首页
				//弹出“注册成功”对话框，清空textfield
				showDialog("注册成功");
				signUpUI.setBlank();
				setFirstView();
			}else{//调用helpTools里的对话框
				//“注册失败，请尝试修改用户名”
				showDialog("注册失败，请重试");
			}
		}
		
		return;
	
	}
	
	public void login(){
		
		String ID = signInUI.getID();
		String password = signInUI.getPassword();
		if(ID.equals("")){
			//弹出“请输入用户名”
			showDialog("请输入用户名");
			return ;
		}
		if(password.equals("")){
			//弹出“请输入密码”
			showDialog("请输入密码");
			return ;
		}
		Identity identity = accountService.getIdentity(ID);
		AccountVO accountVO = new AccountVO(ID,password,identity);
		
		ResultMessage result = accountService.login(accountVO);
		if(result == ResultMessage.USERNAME_NOT_EXIST){
			//弹出"用户名不存在"
			showDialog("用户名不存在");
			return ;
		}else if(result == ResultMessage.UNMATCHED_PASSWORD){
			//弹出“密码错误”
			showDialog("密码错误");
			return ;
		}else if(result == ResultMessage.USER_HAS_LOGIN){
			//用户已登录
			showDialog("用户已在别处登录");
			return ;
		}else if(result == ResultMessage.FAILURE){
			//弹出 系统错误，请重试
			showDialog("系统错误，请重试");
			return ;
		}else{
			//弹出"登陆成功"，清空textfiel，跳入对应用户界面
			showDialog("登陆成功");
			signInUI.setBlank();
			showFirstView(ID,identity);
		}
		
	}
	
	//弹出对话框，文字为传入的str
	private void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
	//根据identity跳入各用户界面(userID为UserCOntroller所需
	private void showFirstView(String userID , Identity identity){
		
		if(identity == Identity.CLIENT){
			userController = new UserMyInfoController(stage, userID);
			userController.setBlankView();
		}else if(identity == Identity.HOTELMANAGER){
			hmOrderManagementController = new HMHotelInfoController(stage,userID);
			hmOrderManagementController.setBlankView();
		}else if(identity == Identity.WEBBUSSINESS){
			wbVIPInfoController = new WBVIPInfoController(stage,userID);
			wbVIPInfoController.setBlankView();
		}else if(identity == Identity.WEBMANAGER){
			webManagerController = new WMUserInfoController(stage ,userID);
			webManagerController.setBlankView();
		}
		
		return ;
	
	}
	
}
