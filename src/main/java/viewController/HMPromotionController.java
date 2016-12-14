package viewController;

import java.util.ArrayList;

import Message.PromotionType;
import javafx.stage.Stage;
import logicService.account.AccountService;
import logicService.order.OrderService;
import logicService.promotion.PromotionService;
import logicService.room.RoomService;
import logicService.stub.PromotionService_Stub;
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
import vo.PromotionVO;

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
	
	private int row;
	private ArrayList<PromotionVO> promotionList;
	
	public HMPromotionController(Stage stage, String userId){
		
		promotionService = new PromotionService_Stub();
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
	
	public HMPromotionController(Stage stage, String userId, int row){
		
		this.stage = stage;
		this.userId = userId;
		this.row = row;
		
		promotionService = new PromotionService_Stub();
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
	
	public void setPromotoinList(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.ALL);
	}
	
	public void setspecialTimePromotion(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.HOTEL_11_11);
	}
	
	public void setBirthdayPromotion(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.HOTEL_BIRTHDAY);
	}

	public void setThreeRoomPromotion(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.HOTEL_3_ROOMS_OR_MORE);
	}
	
	public void setCooperatePromotion(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.HOTEL_COOPREATE_BUSINESS);
	}
	
	public ArrayList<PromotionVO> getPromotionList(){
		return promotionList;
	}
	
	public void setRow(){
		row = existStrategyUI.getRow();
	}
	
	public int getRow(){
		return row;
	}
	
}
