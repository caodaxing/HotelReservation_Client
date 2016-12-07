package viewController;

import javafx.stage.Stage;
import view.right.webManager.userInfo.CheckUser;
import view.right.webManager.userInfo.ModifyUser;
import view.right.webManager.userInfo.SearchUser;

public class WMUserInfoController {

	private Stage stage ;
	
	private CheckUser checkUserUI ;
	private ModifyUser modifyUserUI ;
	private SearchUser searchUserUI;
	
	public WMUserInfoController(Stage stage){
		
		this.stage = stage;
		
		checkUserUI = new CheckUser(this);
		modifyUserUI = new ModifyUser(this);
		searchUserUI = new SearchUser(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckUserView(){
		
		stage.setScene(checkUserUI.getScene());
		
	}
	
	public void setModifyUserUI(){
		
		stage.setScene(modifyUserUI.getScene());
	
	}
	
	public void setSearchUserUI(){
		
		stage.setScene(searchUserUI.getScene());
	
	}
	
}
