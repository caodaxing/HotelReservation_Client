package viewController;

import logic.hotel.HotelController;
import logicService.HotelService;
import view.right.user.checkHotel.SearchResultList;

public class HMOrderManagementController {
	
	private HotelService hotelService;
	private SearchResultList view;
	
	public HMOrderManagementController(){
		
		hotelService = new HotelController();
	}
	
	public void setView(SearchResultList view){
		
		this.view = view;
	}
}
