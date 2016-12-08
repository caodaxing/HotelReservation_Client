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
	//差两个
	
	//管理的页面
	private FirstUI firstUI ;
	private SignInUI signInUI ;
	private SignUpUI signUpUI ;
	
	public AccountController(Stage stage){
		
		this.stage = stage;
		
		accountService = new AccountService_Stub();
		
		vistorController = new VistorController(stage);
		webManagerController = new WMUserInfoController(stage);
		
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
	
	public void setUserBlankView(){
		userController.setBlankView();
	}
	
	public void setVistorBlankView(){
		vistorController.setBlankView();
	}
	
	//待补全
	public void setHotelManagerBlankView(){
		
	}
	
	//待补全
	public void setWebBusinessBlankView(){
		
	}
	
	public void setWebManagerBlankView(){
		webManagerController.setBlankView();
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
		}else{
		
			
			AccountVO accountVO = new AccountVO(userID,password,Identity.CLIENT);
			ResultMessage result = accountService.register(accountVO);
		
			if(result == ResultMessage.SUCCESS){//注册成功则返回首页
				//弹出“注册成功”对话框
				showDialog("注册成功");
				setFirstView();
			}else{//调用helpTools里的对话框
				//“注册失败，请尝试修改用户名”
				showDialog("注册失败，请尝试修改用户名");
			}
		}
	
	}
	
	//弹出对话框，文字为传入的str
	private void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
}
