package viewController;

import java.util.ArrayList;

import javafx.stage.Stage;
import logicService.order.OrderService;
import view.right.user.checkHotel.*;
import vo.EvaluationVO;
import vo.HotelVO;
import vo.OrderVO;

public class UserCheckHotelController extends UserLeftController {
	
	//逻辑层接口（先不写）
	
	//控制的界面
	private EvaluationList evaluationListUI;
	private HistoryOrderList historyOrderListUI;
	private HotelInfo hotelInfoUI;
	private MakeOrder makeOrderUI;
	private RoomList roomListUI;
	private SearchResultList searchResultListUI;
	private SearchHotel searchHotelUI;
	private SuccessOrder successOrderUI;
	
	public UserCheckHotelController(Stage stage , String userID){
		
		this.stage = stage ;
		this.userID = userID;
		
		evaluationListUI = new EvaluationList(this);
		historyOrderListUI = new HistoryOrderList(this);
		hotelInfoUI = new HotelInfo(this);
		makeOrderUI = new MakeOrder(this);
		roomListUI = new RoomList(this);
		searchHotelUI = new SearchHotel(this);
		searchResultListUI = new SearchResultList(this);
		successOrderUI = new SuccessOrder(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setView(int viewIndex){
		
	}
	
	public void setEvaluationListView(){
		
		stage.setScene(evaluationListUI.getScene());
		
	}
	
	public void setHistoryOrderListView(){
		
		stage.setScene(historyOrderListUI.getScene());
		
	}
	
	public void setHotelInfoView(){
		
		stage.setScene(hotelInfoUI.getScene());
	
	}
	
	public void setMakeOrderView(){
		
		stage.setScene(makeOrderUI.getScene());
		
	}
	
	public void setRoomListView(){
		
		stage.setScene(roomListUI.getScene());
		
	}
	
	public void setSearchHotelView(){
		
		stage.setScene(searchHotelUI.getScene());
		
	}
	
	public void setSearchResultList(){
		
		stage.setScene(searchResultListUI.getScene());
	
	}
	
	public void setSuccessOrder(){
		
		stage.setScene(successOrderUI.getScene());
		
	}

	public void searchAndSetSearchHotelView() {
		// TODO Auto-generated method stub
		
	}

	public HotelVO getHotelInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelVO> getSearchHotelList() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getOrderInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EvaluationVO> getEvaluationList() {
		// TODO Auto-generated method stub
		return null;
	}

}
