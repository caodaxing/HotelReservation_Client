package viewController;

import Message.ResultMessage;
import Message.VipType;
import javafx.stage.Stage;
import view.right.user.VIP.RegisterCompanyVIP;
import view.right.user.VIP.RegisterNormalVIP;
import vo.VipVO;

public class UserVIPController extends UserLeftController {

	private RegisterCompanyVIP registerCompanyVIPUI ;
	private RegisterNormalVIP registerNormalVIPUI ;
	
	public UserVIPController(Stage stage , String userID){
		
		super(stage,userID);
		
	}
	
	public void setRegisterCompanyVIPView(){

		registerCompanyVIPUI = new RegisterCompanyVIP(this);
		stage.setScene(registerCompanyVIPUI.getScene());
	
	}
	
	public void setRegisterNormalVIPView(){

		registerNormalVIPUI = new RegisterNormalVIP(this);
		stage.setScene(registerNormalVIPUI.getScene());
		
	}
	
	public void registerVIP(VipType type){
		ResultMessage result = null ;
		if(type == VipType.BIRTHDAY_VIP){
			//注册普通会员
			VipVO VIPInfo = new VipVO(userID,type,1,registerNormalVIPUI.getBirthday());
			result = clientService.registerVIP(VIPInfo);
		}else{
			if(registerCompanyVIPUI.getCompany().equals("")){
				showDialog("请输入企业");
				return ;
			}
			//注册企业会员
			VipVO vo = new VipVO(userID,type,1,registerCompanyVIPUI.getCompany());
			result = clientService.registerVIP(vo);
		}
		
		if(result == ResultMessage.FAILURE){
			showDialog("注册失败，请重试");
			return;
		}else if(result == ResultMessage.SUCCESS){
			//注册成功
			showDialog("注册成功");
			setVIPView();
			stage.show();
		}
	}

}
