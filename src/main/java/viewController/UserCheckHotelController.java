package viewController;

import javafx.stage.Stage;
import logicService.order.OrderService;
import view.right.user.checkHotel.*;

public class UserCheckHotelController {
	
	private Stage stage ;
	private String userID;
	
	//逻辑层接口（先不写）
	private OrderService orderService;
	
	//控制的界面
	private EvaluationList evaluationListUI;
	private HotelFirst firstUI;
	private HistoryOrderList historyOrderListUI;
	private HotelInfo hotelInfoUI;
	private MakeOrder makeOrderUI;
	private RoomList roomListUI;
	private SearchResultList searchResultListUI;
	private SearchHotel searchHotelUI;
	private SuccessOrder successOrderUI;
	
	public UserCheckHotelController(Stage stage , String userID){
		
		this.stage = stage ;
		this.userID = userID ;
		
		
		evaluationListUI = new EvaluationList(this);
		firstUI = new HotelFirst(this);
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
	
	public void setFirstView(){
		
		stage.setScene(firstUI.getScene());
	
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
	
}
