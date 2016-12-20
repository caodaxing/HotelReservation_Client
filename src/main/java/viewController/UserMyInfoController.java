package viewController;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.stage.Stage;
import logic.credit.CreditChange;
import logicService.credit.CreditChangeService;
import view.right.user.myInfo.Blank;
import view.right.user.myInfo.HistoryCredit;
import view.right.user.myInfo.ModifyMyInfo;
import vo.ClientVO;
import vo.CreditChangeVO;

public class UserMyInfoController extends UserLeftController {
	
	//逻辑层接口
	private CreditChangeService creditChangeService ;
	
	//控制的界面
	private Blank blankUI ; 
	private HistoryCredit historyCreditUI ;
	private ModifyMyInfo modifyMyInfoUI ;
	
	public UserMyInfoController(Stage stage , String userID){		

		super(stage,userID);
		
		creditChangeService = new CreditChange();
		
		blankUI = new Blank(this);
		historyCreditUI = new HistoryCredit(this);
		modifyMyInfoUI = new ModifyMyInfo(this);
		
	}

	public void setBlankView(){
		stage.setScene(blankUI.getScene());
	}
	
	public void setHistoryCreditView(){
		historyCreditUI.setListValue();
		stage.setScene(historyCreditUI.getScene());
	}
	
	public void setModifyMyInfoView(){
		stage.setScene(modifyMyInfoUI.getScene());
	}
	
	/*
	 * 修改基本信息
	 */
	public void modifyMyInfo(){
		String name = modifyMyInfoUI.getName();
		String id = modifyMyInfoUI.getID();
		String head = modifyMyInfoUI.getHeadUrl();
		String phone = modifyMyInfoUI.getPhone();
		ClientVO vo = clientService.getClientInfo(userID);
		vo.trueName = name;
		vo.phoneNumber = phone ;
		pictureService.saveUserImage(userID, head)  ;
		vo.identityID = id;
		
		ResultMessage result = clientService.updateClientInfo(vo);
		if(result == ResultMessage.FAILURE){
			//修改失败
			showDialog("系统错误，请重试");
		}else if(result == ResultMessage.SUCCESS){
			//修改成功，弹框清空textfield返回查看界面
			showDialog("修改成功");
			modifyMyInfoUI.setBlank();
			setCheckMyInfoView();
			stage.show();
		}
	}

	/*
	 * 返回当前用户的历史信用记录
	 */
	public ArrayList<CreditChangeVO> getCreditList() {
		return creditChangeService.getCreditHistory(userID);
	}
	
	/*
	 * 返回当前用户的基本信息
	 */
	public ClientVO getClientInfo(){
		
		return clientService.getClientInfo(userID);
		
	}
	
}
