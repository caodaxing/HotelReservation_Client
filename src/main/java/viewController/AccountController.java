package viewController;

import javafx.stage.Stage;
import view.account.FirstUI;
import view.account.SignInUI;
import view.account.SignUpUI;

public class AccountController {

	private Stage stage ;
	
	private FirstUI firstUI ;
	private SignInUI signInUI ;
	private SignUpUI signUpUI ;
	
	public AccountController(Stage stage){
		
		this.stage = stage;
		
		firstUI = new FirstUI(this);
		signInUI = new SignInUI(this);
		signUpUI = new SignUpUI(this);
		
	}
	
	public Stage getStage(){
		
		return stage ;
		
	}
	
	public void setFirstView(){
		
		stage.setScene(firstUI.getScene());
	
	}
	
	public void setSignInView(){
		
		stage.setScene(signInUI.getScene());
	
	}
	
	public void setSignUpView(){
		
		stage.setScene(signUpUI.getScene());
	
	}
	
}
