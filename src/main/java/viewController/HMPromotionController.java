package viewController;

import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.order.OrderService;
import logicService.promotion.PromotionService;
import logicService.room.RoomService;
import view.right.hotelManager.promotion.CheckBirthdayStrategy;
import view.right.hotelManager.promotion.CheckCooperateCompanyStrategy;
import view.right.hotelManager.promotion.CheckSpecialTimeStrategy;
import view.right.hotelManager.promotion.CheckThreeRoomsStrategy;
import view.right.hotelManager.promotion.Choose;
import view.right.hotelManager.promotion.First;
import view.right.hotelManager.promotion.SetBirthdayStrategy;
import view.right.hotelManager.promotion.SetCooperateCompanyStrategy;
import view.right.hotelManager.promotion.SetSpecialTimeStrategy;
import view.right.hotelManager.promotion.SetThreeRoomsStrategy;

public class HMPromotionController {
	
	private Stage stage;
	
	//逻辑层接口
	private PromotionService promotionService;
	private OrderService orderService;
	private RoomService roomService;
	private AccountService accountService;
	
	//控制的界面
	private CheckBirthdayStrategy checkBirthdayStrategyUI;
	private CheckCooperateCompanyStrategy checkCooperateCompanyStrategyUI;
	private CheckSpecialTimeStrategy checkSpecailTimeStrategyUI;
	private CheckThreeRoomsStrategy checkThreeRoomsStrategyUI;
	private Choose chooseUI;
	private First firstUI;
	private SetBirthdayStrategy setBirthdayStrategyUI;
	private SetCooperateCompanyStrategy setCooperateCompanyStrategyUI;
	private SetSpecialTimeStrategy setSpecialTimeStrategyUI;
	private SetThreeRoomsStrategy setThreeRoomsStrategyUI;
	
	public HMPromotionController(Stage stage){
		
		this.stage = stage;
		
		firstUI = new First(this);
		chooseUI = new Choose(this);
//		promotionService = new Promotion();
//		orderService = new Order();
//		roomService = new Room();
//		accountService = new Account();
		
		
	}
	
	public void setFirstView(){
		stage.setScene(firstUI.getScene());
	}
	
	public Stage getFirstStage(){
		return stage;
	}
	
	public void setChooseView(){
		stage.setScene(chooseUI.getScene());
	}
	
	public Stage getChooseStage(){
		return stage;
	}
}
