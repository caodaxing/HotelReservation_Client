package viewController;

import javafx.stage.Stage;
import view.right.webManager.userInfo.Blank;
import view.right.webManager.userInfo.CheckUser;
import view.right.webManager.userInfo.ModifyUser;
import view.right.webManager.userInfo.SearchUser;

public class WMUserInfoController extends WebManagerLeftController{

	private Blank blankUI ;
	private CheckUser checkUserUI ;
	private ModifyUser modifyUserUI ;
	
	public WMUserInfoController(Stage stage ,String userID){
		
		this.stage = stage;
		this.userID = userID;
		
		blankUI = new Blank(this);
		checkUserUI = new CheckUser(this);
		modifyUserUI = new ModifyUser(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setBlankView(){
		
		stage.setScene(blankUI.getScene());
		
	}
	
	public void setCheckUserView(){
		
		stage.setScene(checkUserUI.getScene());
		
	}
	
	public void setModifyUserUI(){
		
		stage.setScene(modifyUserUI.getScene());
	
	}
	
}
