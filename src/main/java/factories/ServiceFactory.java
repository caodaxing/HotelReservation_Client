package factories;

import logic.account.Account;
import logic.credit.CreditController;
import logic.evaluation.EvaluationController;
import logic.hotel.HotelController;
import logic.order.OrderController;
import logic.orderManagement.OrderManagementController;
import logic.promotion.PromotionController;
import logic.room.RoomController;
import logic.user.Client;
import logic.user.HotelManager;
import logic.user.WebBusiness;
import logic.user.WebManager;

/**
 * 创建logic service实例的工厂类
 * 同时单例模式
 * 工厂类只有一个，所有包的controller实例也只有一个
 * @author Mark.W
 *
 */
public class ServiceFactory {

	private static ServiceFactory serviceFactory;
	
	public static ServiceFactory getInstance() {
		if(serviceFactory == null) {
			serviceFactory = new ServiceFactory();
		}
		return serviceFactory;
	}
	
	public Account createAccount(){
		return new Account();
	}
	
	public Client createClient(String userID){
		return new Client(userID);
	}
	
	public HotelManager createHotelManager(String userID){
		return new HotelManager(userID);
	}
	
	public WebManager createWebManager(String userID){
		return new WebManager(userID);
	}
	
	public WebBusiness createWebBusiness(String userID){
		return new WebBusiness(userID);
	}
	
	public CreditController createCreditController(){
		return new CreditController();
	}
	
	public OrderController createOrderController(){
		return new OrderController();
	}

	public OrderManagementController createOrderManagementController(){
		return new OrderManagementController();
	}
	
	public RoomController createRoomController(){
		return new RoomController();
	}
	
	public HotelController createHotelController(){
		return new HotelController();
	}

	public EvaluationController createEvaluationController(){
		return new EvaluationController();
	}
	
	public PromotionController createPromotionController(){
		return new PromotionController();
	}
}

