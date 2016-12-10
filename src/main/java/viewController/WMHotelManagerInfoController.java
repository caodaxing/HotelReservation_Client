package viewController;

import javafx.stage.Stage;
import view.right.webManager.hotelManagerInfo.CheckHotelManager;
import view.right.webManager.hotelManagerInfo.ModifyHotelManager;

public class WMHotelManagerInfoController extends WebManagerLeftController{
	
	private CheckHotelManager checkHotelManagerUI ;
	private ModifyHotelManager modifyHotelManagerUI ;

	public WMHotelManagerInfoController(Stage stage ,String userID){
		
		this.stage = stage ;
		this.userID = userID ;
		
		checkHotelManagerUI = new CheckHotelManager(this);
		modifyHotelManagerUI = new ModifyHotelManager(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckHotelManagerView(){
		
		stage.setScene(checkHotelManagerUI.getScene());
		
	}
	
	public void setModifyHotelManagerView(){
		
		stage.setScene(modifyHotelManagerUI.getScene());
		
	}
	
}
