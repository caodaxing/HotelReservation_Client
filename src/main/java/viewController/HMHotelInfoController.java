package viewController;

import javafx.stage.Stage;
import logicService.hotel.CheckHotelService;
import logicService.stub.HotelService_Stub;
import view.right.hotelManager.hotelInfo.Blank;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;
import vo.HotelVO;

public class HMHotelInfoController extends HotelManagerLeftController{
	
	//逻辑层接口
	private CheckHotelService checkHotelService;
	
	//控制的界面
	private ModifyHotelInfo modifyHotelInfoUI;
	private Blank blankUI;
	
	private HotelVO hotelVO;
	
	public HMHotelInfoController(Stage stage, String userId){
		
		//checkHotelService = new CheckHotel();
		
		this.stage = stage;
		this.userId = userId;
		checkHotelService = new HotelService_Stub();
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
	
	public HotelVO getHotelVO(){
		return checkHotelService.getHotelnfo(userId);
	}
}
