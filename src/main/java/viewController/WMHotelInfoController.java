package viewController;

import javafx.stage.Stage;
import view.right.webManager.hotelInfo.AddHotel;
import view.right.webManager.hotelInfo.AddHotelManager;

public class WMHotelInfoController {
	
	private Stage stage ;
	
	private AddHotel addHotelUI ;
	private AddHotelManager addHotelManagerUI ;
	
	public WMHotelInfoController(Stage stage ){
		
		this.stage = stage ;
		
		addHotelUI = new AddHotel(this);
		addHotelManagerUI = new AddHotelManager(this);
		
	}
	
	public void setAddHotelView(){
		
		stage.setScene(addHotelUI.getScene());
		
	}
	
	public void setAddHotelManagerView(){
		
		stage.setScene(addHotelManagerUI.getScene());
	
	}

}
