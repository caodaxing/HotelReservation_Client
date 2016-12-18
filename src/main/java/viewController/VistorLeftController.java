package viewController;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.helpTools.OneButtonDialog;

public class VistorLeftController {
	
	private AccountController accountController ;
	
	protected Stage stage;
	
	public void setSignInView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预订系统");
		accountController = new AccountController(newStage);
		accountController.setSignInView();
		newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                accountController.logout();
            }
        });
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
		newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                accountController.logout();
            }
        });
		newStage.setResizable(false);
		newStage.show();
	}
	
	public void showDialog(String str){
		OneButtonDialog dialog = new OneButtonDialog(str);
		dialog.show();
	}
	
}
