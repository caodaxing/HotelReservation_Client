package viewController;

import javafx.stage.Stage;
import view.right.webManager.hotelManagerInfo.CheckHotelManager;
import view.right.webManager.hotelManagerInfo.ModifyHotelManager;

public class WMHotelManagerInfoController {
	
	private Stage stage ;
	
	private CheckHotelManager checkHotelManagerUI ;
	private ModifyHotelManager modifyHotelManagerUI ;

	public WMHotelManagerInfoController(Stage stage){
		
		this.stage = stage ;
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
