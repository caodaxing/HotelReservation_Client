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
import view.right.hotelManager.promotion.ExistStrategy;
import view.right.hotelManager.promotion.PromotionFirst;
import view.right.hotelManager.promotion.SetBirthdayStrategy;
import view.right.hotelManager.promotion.SetCooperateCompanyStrategy;
import view.right.hotelManager.promotion.SetSpecialTimeStrategy;
import view.right.hotelManager.promotion.SetThreeRoomsStrategy;

public class HMPromotionController extends HotelManagerLeftController{
	
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
	private ExistStrategy existStrategyUI;
	private PromotionFirst firstUI;
	private SetBirthdayStrategy setBirthdayStrategyUI;
	private SetCooperateCompanyStrategy setCooperateCompanyStrategyUI;
	private SetSpecialTimeStrategy setSpecialTimeStrategyUI;
	private SetThreeRoomsStrategy setThreeRoomsStrategyUI;
	
	public HMPromotionController(Stage stage, String userId){
		
		this.stage = stage;
		this.userId = userId;
		
		checkBirthdayStrategyUI = new CheckBirthdayStrategy(this);
		checkCooperateCompanyStrategyUI = new CheckCooperateCompanyStrategy(this);
		checkSpecailTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkThreeRoomsStrategyUI = new CheckThreeRoomsStrategy(this);
		chooseUI = new Choose(this);
		existStrategyUI = new ExistStrategy(this);
		firstUI = new PromotionFirst(this);
		setBirthdayStrategyUI = new SetBirthdayStrategy(this);
		setCooperateCompanyStrategyUI = new SetCooperateCompanyStrategy(this);
		setSpecialTimeStrategyUI = new SetSpecialTimeStrategy(this);
		setThreeRoomsStrategyUI = new SetThreeRoomsStrategy(this);
//		promotionService = new Promotion();
//		orderService = new Order();
//		roomService = new Room();
//		accountService = new Account();
		
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckBirthdayStrategyView(){
		stage.setScene(checkBirthdayStrategyUI.getScene());
	}
	
	public void setCheckCooperateCompanyStrategyView(){
		stage.setScene(checkCooperateCompanyStrategyUI.getScene());
	}
	
	public void setCheckSpecialTimeStrategyView(){
		stage.setScene(checkSpecailTimeStrategyUI.getScene());
	}
	
	public void setCheckThreeRoomsStrategyView(){
		stage.setScene(checkThreeRoomsStrategyUI.getScene());
	}
	public void setChooseView(){
		stage.setScene(chooseUI.getScene());
	}
	
	public void setExistStrategy(){
		stage.setScene(existStrategyUI.getScene());
	}
	
	public void setFirstView(){
		stage.setScene(firstUI.getScene());
	}
	
	public void setSetBirthdayStrategyView(){
		stage.setScene(setBirthdayStrategyUI.getScene());
	}
	
	public void setSetCooperateCompanyStrategyView(){
		stage.setScene(setCooperateCompanyStrategyUI.getScene());
	}
	
	public void setSetSpecialTimeStrategyView(){
		stage.setScene(setSpecialTimeStrategyUI.getScene());
	}
	
	public void setSetThreeRoomsStrategyView(){
		stage.setScene(setThreeRoomsStrategyUI.getScene());
	}
	
	
}
