package viewController;

import java.util.ArrayList;

import Message.HotelSearchCondition;
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
	
	private HotelInfo hotelInfoUI ;
	private SearchHotel searchHotelUI ;
	private SearchResultList searchResultListUI ;
	
	private ArrayList<HotelVO> hotelList;
	private String hotelID;
	
	public VistorController(Stage stage){
		
		this.stage = stage ;
		
		searchService = new HotelService_Stub();
		checkService = new HotelService_Stub();
		
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
		stage.setScene(hotelInfoUI.getScene());
		hotelInfoUI.setText();
		hotelInfoUI.setImage();
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

}
