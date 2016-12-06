package viewController;

import javafx.stage.Stage;
import logic.credit.CreditChange;
import logicService.credit.CreditChangeService;
import logicService.credit.CreditService;
import logicService.stub.CreditChangeService_Stub;
import logicService.user.ClientService;
import view.right.user.myInfo.CheckMyInfo;
import view.right.user.myInfo.HistoryCredit;
import view.right.user.myInfo.ModifyMyInfo;

public class UserMyInfoController {

	private Stage stage ;
	
	//逻辑层接口
	private CreditChangeService creditChangeService ;
	private ClientService clientService ;
	
	//控制的界面
	private CheckMyInfo checkMyInfoUI ;
	private HistoryCredit historyCreditUI ;
	private ModifyMyInfo modifyMyInfoUI ;
	
	public UserMyInfoController(Stage stage){		
		
		this.stage = stage ;

		creditChangeService = new CreditChangeService_Stub("12345");
		
		
		checkMyInfoUI = new CheckMyInfo(this);
		historyCreditUI = new HistoryCredit(this);
		modifyMyInfoUI = new ModifyMyInfo(this);
		
	}
	
	public void setView(int viewIndex){
		
		switch (viewIndex){
		case 0:
			setCheckMyInfoView();
			break;
		case 1:
			setHistoryCreditView();
			break;
		case 2:
			setModifyMyInfoView();
			break;
		}
		
	}
	
	private void setCheckMyInfoView(){
		
		stage.setScene(checkMyInfoUI.getScene());
		
	}
	
	private void setHistoryCreditView(){
		
		stage.setScene(historyCreditUI.getScene());
		
	}
	
	private void setModifyMyInfoView(){
		
		stage.setScene(modifyMyInfoUI.getScene());
		
	}
	
}
