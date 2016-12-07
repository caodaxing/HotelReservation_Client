package viewController;

import javafx.stage.Stage;
import view.right.vistor.SearchHotel;
import view.right.vistor.SearchResultList;
import view.right.vistor.HotelInfo;

public class VistorController {

	private Stage stage;
	
	private HotelInfo hotelInfoUI ;
	private SearchHotel searchHotelUI ;
	private SearchResultList searchResultListUI ;
	
	public VistorController(Stage stage){
		
		this.stage = stage ;
		
		hotelInfoUI = new HotelInfo(this);
		searchHotelUI = new SearchHotel(this);
		searchResultListUI = new SearchResultList(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setHotelInfoView(){
		
		stage.setScene(hotelInfoUI.getScene());
		
	}
	
	public void setSearchHotelView(){
		
		stage.setScene(searchHotelUI.getScene());
	
	}
	
	public void setSearchResultListView(){
		
		stage.setScene(searchResultListUI.getScene());
	
	}
	
}
