package viewController;

import javafx.stage.Stage;
import view.right.user.VIP.CheckCompanyVIP;
import view.right.user.VIP.CheckNormalVIP;
import view.right.user.VIP.Choose;
import view.right.user.VIP.RegisterCompanyVIP;
import view.right.user.VIP.RegisterNormalVIP;

public class UserVIPController {

	private Stage stage ;
	private String userID;
	
	private CheckCompanyVIP checkCompanyVIPUI ;
	private CheckNormalVIP checkNormalVIPUI ;
	private Choose chooseUI ;
	private RegisterCompanyVIP registerCompanyVIPUI ;
	private RegisterNormalVIP registerNormalVIPUI ;
	
	public UserVIPController(Stage stage , String userID){
		
		this.stage = stage ;
		this.userID = userID ;
		
		checkCompanyVIPUI = new CheckCompanyVIP(this);
		checkNormalVIPUI = new CheckNormalVIP(this);
		chooseUI = new Choose(this);
		registerCompanyVIPUI = new RegisterCompanyVIP(this);
		registerNormalVIPUI = new RegisterNormalVIP(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckCompanyVIPView (){
		
		stage.setScene(checkCompanyVIPUI.getScene());
		
	}
	
	public void setCheckNormalVIPVIew(){
		
		stage.setScene(checkNormalVIPUI.getScene());
	
	}
	
	public void setChooseView(){
		
		stage.setScene(chooseUI.getScene());
	
	}
	
	public void setRegisterCompanyVIPView(){
		
		stage.setScene(registerCompanyVIPUI.getScene());
	
	}
	
	public void setRegisterNormalVIPView(){
		
		stage.setScene(registerNormalVIPUI.getScene());
	
	}

}
