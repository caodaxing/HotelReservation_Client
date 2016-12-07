package viewController;

import javafx.stage.Stage;
import logicService.hotel.CheckHotelService;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;

public class HMHotelInfoController {
	
	private Stage stage;
	
	//逻辑层接口
	private CheckHotelService checkHotelService;
	
	//控制的界面
	private ModifyHotelInfo modifyHotelInfoUI;
	
	public HMHotelInfoController(Stage stage){
		
		//checkHotelService = new CheckHotel();
		
		this.stage = stage;
		
		
	}
	
	public void setModifyControllerView(ModifyHotelInfo view){
		this.modifyHotelInfoUI = view;
	}
}
