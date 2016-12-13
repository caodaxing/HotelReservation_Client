package viewController;

import javafx.stage.Stage;
import view.helpTools.OneButtonDialog;

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
		newStage.setResizable(false);
		newStage.show();
	}
	
	public void setSignUpView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		accountController.setSignUpView();
		newStage.setResizable(false);
		newStage.show();
	}
	
	public void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
}
