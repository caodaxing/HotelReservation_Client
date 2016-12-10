package viewController;

import javafx.stage.Stage;

public class VistorLeftController {
	
	private AccountController accountController ;
	
	protected Stage stage;
	
	public VistorLeftController(){
		
	}
	
	public void setSignInView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		accountController.setSignInView();
		newStage.show();
	}
	
	public void setSignUpView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		accountController.setSignUpView();
		newStage.show();
	}
	
}