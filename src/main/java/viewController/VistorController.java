package viewController;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.hotel.CheckHotelService;
import logicService.hotel.SearchHotelService;
import logicService.stub.HotelService_Stub;
import view.right.vistor.SearchHotel;
import view.right.vistor.SearchResultList;
import vo.HotelSearchVO;
import vo.HotelVO;
import view.right.vistor.Blank;
import view.right.vistor.HotelInfo;

public class VistorController extends VistorLeftController{
	
	private SearchHotelService searchService;
	private CheckHotelService checkService;
	
	private static Blank blankUI;
	private HotelInfo hotelInfoUI ;
	private SearchHotel searchHotelUI ;
	private SearchResultList searchResultListUI ;
	
	HotelSearchVO searchVO ;
	String hotelID;
	
	public VistorController(Stage stage){
		
		this.stage = stage ;
		
		//逻辑层接口初始化，待修改
		//searchService = new HotelService_Stub();
		//checkService = new HotelService_Stub();
		
		blankUI = new Blank(this);
		hotelInfoUI = new HotelInfo(this);
		searchHotelUI = new SearchHotel(this);
		searchResultListUI = new SearchResultList(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setBlankView(){
		
		stage.setScene(blankUI.getScene());
		
	}
	
	public void setHotelInfoView(String hotelID){
		 
		this.hotelID = hotelID;
		stage.setScene(hotelInfoUI.getScene());
		
	}
	
	public void setSearchHotelView(){

		HotelSearchVO vo = searchHotelUI.getSearchVO();
		stage.setScene(searchHotelUI.getScene());
	
	}
	
	public void setSearchResultListView(){
		
		stage.setScene(searchResultListUI.getScene());
	
	}
	
	public ArrayList<HotelVO> getSearchHotelList(){
		return searchService.search(searchVO);
	}
	
	public HotelVO getHotelInfo(){
		return checkService.getHotelnfo(hotelID);
	}
}
