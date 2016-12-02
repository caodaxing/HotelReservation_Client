package viewController;

import logicService.order.OrderService;
import view.right.user.checkHotel.*;

public class UserCheckHotelController {
	
	//逻辑层接口（先不写）
	private OrderService orderService;
	
	//控制的界面
	private EvaluationList evaluationListUI;
	private First firstUI;
	private HistoryOrderList historyOrderListUI;
	private HotelInfo hotelInfoUI;
	private MakeOrder makeOrderUI;
	private RoomList roomListUI;
	private SearchResultList searchRessultListUI;
	private SearchHotel searchHotelUI;
	
	
	public UserCheckHotelController(){
		//orderService = new OrderController();
	}
	
	public void setView(SearchHotel view){
		this.searchHotelUI = view;
	}
	
	
	
}
