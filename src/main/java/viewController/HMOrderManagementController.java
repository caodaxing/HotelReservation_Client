package viewController;


import logic.hotel.UpdateHotel;
import logicService.hotel.UpdateHotelService;
import view.right.user.checkHotel.SearchResultList;

public class HMOrderManagementController {
	
	private UpdateHotelService updateHotelService;
	private SearchResultList view;
	
	public HMOrderManagementController(){
		
		updateHotelService = new UpdateHotel();
	}
	
	public void setView(SearchResultList view){
		
		this.view = view;
	}
}
