package viewController;

import logic.hotel.HotelController;
import logicService.promotion.HotelService;
import view.right.user.checkHotel.SearchResultList;

public class HMOrderManagementController {
	
	private UpdateHotelService updateHotelService;
	private SearchResultList view;
	
	public HMOrderManagementController(){
		
		updateHotelService = new HotelController();
	}
	
	public void setView(SearchResultList view){
		
		this.view = view;
	}
}
