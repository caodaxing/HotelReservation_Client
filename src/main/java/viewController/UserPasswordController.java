package viewController;

import javafx.stage.Stage;
import view.right.user.password.ModifyPassword;

public class UserPasswordController {

	private Stage stage;
	private String userID;
	
	private ModifyPassword modifyPasswordUI;
	
	private UserPasswordController(Stage stage , String userID){
		
		this.stage = stage;
		this.userID = userID;
		
		modifyPasswordUI = new ModifyPassword(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setPasswordView(){
		
		stage.setScene(modifyPasswordUI.getScene());
		
	}
	
}
