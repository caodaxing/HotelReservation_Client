package factories;

import logic.account.Account;
import logic.credit.CreditController;
import logic.evaluation.EvaluationController;
import logic.hotel.HotelController;
import logic.order.OrderController;
import logic.orderManagement.OrderManagementController;
import logic.promotion.PromotionController;
import logic.room.RoomController;
import logic.user.UserController;

/**
 * 创建logic service实例的工厂类
 * 采用单例模式，工厂类只有一个，所有包的controller实例也只有一个
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
	
	private Account account;
	private UserController userController;
	private CreditController creditController;
	private OrderController orderController;
	private OrderManagementController orderManagementController; 
	private RoomController roomController;
	private HotelController hotelController;
	private EvaluationController evaluationController;
	private PromotionController promotionController;
	
	public Account createAccount(){
		if(account == null) {
			account = new Account();
		}
		return account;
	}
	
	public UserController createUserController(){
		if(userController == null) {
			userController = new UserController();
		}
		return userController;
	}
	
	public CreditController createCreditController(){
		if(creditController == null) {
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public OrderController createOrderController(){
		if(orderController == null) {
			orderController = new OrderController();
		}
		return orderController;
	}

	public OrderManagementController createOrderManagementController(){
		if(orderManagementController == null) {
			orderManagementController = new OrderManagementController();
		}
		return orderManagementController;
	}
	
	public RoomController createRoomController(){
		if(roomController == null) {
			roomController = new RoomController();
		}
		return roomController;
	}
	
	public HotelController createHotelController(){
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}

	public EvaluationController createEvaluationController(){
		if(evaluationController == null) {
			evaluationController = new EvaluationController();
		}
		return evaluationController;
	}
	
	public PromotionController createPromotionController(){
		if(promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}
}

