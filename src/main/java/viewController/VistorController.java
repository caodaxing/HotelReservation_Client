package viewController;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import javafx.stage.Stage;
import logic.hotel.CheckHotel;
import logic.picture.Picture;
import logicService.hotel.CheckHotelService;
import logicService.hotel.SearchHotelService;
import logicService.picture.PictureService;
import view.right.vistor.SearchHotel;
import view.right.vistor.SearchResultList;
import vo.HotelSearchVO;
import vo.HotelVO;
import view.right.vistor.HotelInfo;

public class VistorController extends VistorLeftController{
	
	private SearchHotelService searchService;
	private CheckHotelService checkService;
	private PictureService pictureService;
	
	private HotelInfo hotelInfoUI ;
	private SearchHotel searchHotelUI ;
	private SearchResultList searchResultListUI ;
	
	private ArrayList<HotelVO> hotelList;
	private String hotelID;
	
	public VistorController(Stage stage){
		
		this.stage = stage ;
		
		searchService = new logic.hotel.SearchHotel();
		checkService = new CheckHotel();
		pictureService = new Picture();
		
		hotelInfoUI = new HotelInfo(this);
		searchHotelUI = new SearchHotel(this);
		searchResultListUI = new SearchResultList(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setHotelID(int row){
		hotelID = hotelList.get(row).hoteID;
	}
	
	public void setSearchHotelView(){
		//生成新的searchHotelView，searchResultList，hotelInfo
		searchHotelUI = new SearchHotel(this);
		searchResultListUI = new SearchResultList(this);
		hotelInfoUI = new HotelInfo(this);
		stage.setScene(searchHotelUI.getScene());
		//清空hotelList和hotelID
		hotelList = null;
		hotelID = null;
	}
	
	public void setHotelInfoView(){
		hotelInfoUI = new HotelInfo(this);
		hotelInfoUI.setText();
		hotelInfoUI.setFirstImage();
		stage.setScene(hotelInfoUI.getScene());
	}
	
	//搜索酒店，设置界面，设置list
	public void searchAndSetSearchHotelListView(){
		HotelSearchVO vo = searchHotelUI.getSearchVO();
		if(vo == null){
			return;
		}
		if(vo.startTime.equals("x")){
			return ;
		}
		if(vo.city.equals("") || vo.tradingArea.equals("")){
			showDialog("请输入酒店城市和商圈");
			return ;
		}
		hotelList = searchService.search(searchHotelUI.getSearchVO());
		//若为空
		if(hotelList == null){
			showDialog("没有符合条件的酒店");
			return ;
		}
		//不为空则跳转
		setSearchResultListView();
	}
	
	public void setSearchResultListView(){
		searchResultListUI = new SearchResultList(this);
		searchResultListUI.setListValue();
		stage.setScene(searchResultListUI.getScene());
	}
	
	//返回搜索到的酒店列表
	public ArrayList<HotelVO> getHotelList(){
		return hotelList;
	}
	
	//返回排序后的列表
	public void setSortedList(HotelSearchCondition condition){
		hotelList =  searchService.getSortedList(condition, hotelList);
	}
	
	public HotelVO getHotelInfo(){
		return checkService.getHotelnfo(hotelID);
	}
	
	public ArrayList<String> getHotelImage(){
		return pictureService.getHotelImage(hotelID);
	}
	

	public ArrayList<String> getCityList() {
		return searchService.getCities();
	}

	public ArrayList<String> getTradingAreaList(String city) {
	   return searchService.getTradingArea(city);
	}
	
}
