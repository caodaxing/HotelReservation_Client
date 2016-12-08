package viewController;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.stage.Stage;
import logic.credit.CreditChange;
import logicService.credit.CreditChangeService;
import logicService.stub.ClientService_Stub;
import logicService.stub.CreditChangeService_Stub;
import logicService.user.ClientService;
import view.right.user.myInfo.Blank;
import view.right.user.myInfo.CheckMyInfo;
import view.right.user.myInfo.HistoryCredit;
import view.right.user.myInfo.ModifyMyInfo;
import vo.ClientVO;
import vo.CreditChangeVO;

public class UserMyInfoController {

	private Stage stage ;
	private String userID;
	
	//逻辑层接口
	private CreditChangeService creditChangeService ;
	private ClientService clientService ;
	
	//控制的界面
	private Blank blankUI ; 
	private CheckMyInfo checkMyInfoUI ;
	private HistoryCredit historyCreditUI ;
	private ModifyMyInfo modifyMyInfoUI ;
	
	public UserMyInfoController(Stage stage , String userID){		
		
		this.stage = stage ;
		this.userID = userID;

		creditChangeService = new CreditChangeService_Stub(userID);
		clientService = new ClientService_Stub(userID);
		
		blankUI = new Blank(this);
		checkMyInfoUI = new CheckMyInfo(this);
		historyCreditUI = new HistoryCredit(this);
		modifyMyInfoUI = new ModifyMyInfo(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}

	public void setBlankView(){
		
		stage.setScene(blankUI.getScene());
		
	}
	
	public void setCheckMyInfoView(){
		
		stage.setScene(checkMyInfoUI.getScene());
		
	}
	
	public void setHistoryCreditView(){
		
		stage.setScene(historyCreditUI.getScene());
		
	}
	
	public void setModifyMyInfoView(){
		
		stage.setScene(modifyMyInfoUI.getScene());
		
	}
	
	private ClientVO getClientInfo(){
		
		return clientService.getClientInfo(userID);
		
	}
	
	private ResultMessage updateClientInfo(ClientVO clientInfo){
		
		return clientService.updateClientInfo(clientInfo);
		
	}
	
	private ArrayList<CreditChangeVO> getHistoryCredit(){
		
		return creditChangeService.getCreditHistory(userID);
		
	}
	
}
