package viewController;

import logicService.hotel.CheckHotelService;
import view.right.hotelManager.hotelInfo.ModifyHotelInfo;

public class HMHotelInfoController {
	
	//逻辑层接口
	private CheckHotelService checkHotelService;
	
	//控制的界面
	private ModifyHotelInfo modifyHotelInfoUI;
	
	public HMHotelInfoController(){
		//checkHotelService = new CheckHotel();
	}
	
	public void setView(ModifyHotelInfo view){
		this.modifyHotelInfoUI = view;
	}
}
