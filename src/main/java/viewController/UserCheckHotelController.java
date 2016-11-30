package viewController;

import logic.order.OrderController;
import logicService.OrderService;
import view.right.hotelManager.orderManagement.SearchOrder;

public class UserCheckHotelController {
	
	private OrderService orderService;
	private SearchOrder view;
	
	public UserCheckHotelController(){
		orderService = new OrderController();
	}
	
	public void setView(SearchOrder view){
		this.view = view;
	}
	
}
