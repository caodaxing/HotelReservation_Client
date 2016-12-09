package viewController;

import javafx.stage.Stage;

public class VistorLeftController {
	
	protected AccountController accountController ;
	
	protected Stage stage ;
	
	public void setSignInView(){
		accountController.setSignInView();
		stage.show();
	}
	
	public void setSignUpView(){
		accountController.setSignInView();
		stage.show();
	}
	
}
