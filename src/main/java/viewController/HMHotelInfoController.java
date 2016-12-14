package viewController;

import javafx.stage.Stage;
import logicService.hotel.CheckHotelService;
import view.right.hotelManager.hotelInfo.Blank;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;

public class HMHotelInfoController extends HotelManagerLeftController{
	
	//逻辑层接口
	private CheckHotelService checkHotelService;
	
	//控制的界面
	private ModifyHotelInfo modifyHotelInfoUI;
	private Blank blankUI;
	
	public HMHotelInfoController(Stage stage, String userId){
		
		//checkHotelService = new CheckHotel();
		
		this.stage = stage;
		this.userId = userId;
		
		modifyHotelInfoUI = new ModifyHotelInfo(this);
		blankUI = new Blank(this);
		
	}
	
	public void setModifyInfoView(){
		stage.setScene(modifyHotelInfoUI.getScene());
	}
	
	public void setBlankView(){
		stage.setScene(blankUI.getScene());
	}
	
	public Stage getStage(){
		return stage;
	}
}
