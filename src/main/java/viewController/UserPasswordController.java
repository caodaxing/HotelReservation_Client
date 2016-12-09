package viewController;

import javafx.stage.Stage;
import view.right.user.password.ModifyPassword;

public class UserPasswordController extends UserLeftController{

	private UserPasswordController(Stage stage , String userID){
		
		this.stage = stage;
		this.userID = userID;
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setPasswordView(){
		
		stage.setScene(modifyPasswordUI.getScene());
		
	}
	
}
