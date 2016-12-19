package viewController;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import javafx.stage.Stage;
import logic.promotion.ManagePromotion;
import logicService.promotion.ManagePromotionService;
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
	
	
	//逻辑层接口
	private ManagePromotionService promotionService;
	
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
	
//	private int row;
	protected String promotionId;
	protected ArrayList<PromotionVO> promotionList;
	
	public HMPromotionController(Stage stage, String userId){
		
		
		super(stage,userId);
		promotionService = new ManagePromotion();
		checkBirthdayStrategyUI = new CheckBirthdayStrategy(this);
		checkCooperateCompanyStrategyUI = new CheckCooperateCompanyStrategy(this);
		checkSpecailTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkThreeRoomsStrategyUI = new CheckThreeRoomsStrategy(this);
		chooseUI = new Choose(this);
//		existStrategyUI = new ExistStrategy(this);
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
	
//	public HMPromotionController(Stage stage, String userId, int row){
//		
//		super(stage,userId);
//		this.stage = stage;
//		this.userId = userId;
////		this.row = row;
//		
//		promotionService = new ManagePromotion();
//		checkBirthdayStrategyUI = new CheckBirthdayStrategy(this);
//		checkCooperateCompanyStrategyUI = new CheckCooperateCompanyStrategy(this);
//		checkSpecailTimeStrategyUI = new CheckSpecialTimeStrategy(this);
//		checkThreeRoomsStrategyUI = new CheckThreeRoomsStrategy(this);
//		chooseUI = new Choose(this);
//		existStrategyUI = new ExistStrategy(this);
//		firstUI = new PromotionFirst(this);
//		setBirthdayStrategyUI = new SetBirthdayStrategy(this);
//		setCooperateCompanyStrategyUI = new SetCooperateCompanyStrategy(this);
//		setSpecialTimeStrategyUI = new SetSpecialTimeStrategy(this);
//		setThreeRoomsStrategyUI = new SetThreeRoomsStrategy(this);
////		promotionService = new Promotion();
////		orderService = new Order();
////		roomService = new Room();
////		accountService = new Account();
//		
//		
//	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckBirthdayStrategyView(){
		checkBirthdayStrategyUI = new CheckBirthdayStrategy(this);
		checkBirthdayStrategyUI.setText();
		stage.setScene(checkBirthdayStrategyUI.getScene());
	}
	
	public void setCheckCooperateCompanyStrategyView(){
		checkCooperateCompanyStrategyUI = new CheckCooperateCompanyStrategy(this);
		checkCooperateCompanyStrategyUI.setText();
		stage.setScene(checkCooperateCompanyStrategyUI.getScene());
	}
	
	public void setCheckSpecialTimeStrategyView(){
		checkSpecailTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkSpecailTimeStrategyUI.setText();
		stage.setScene(checkSpecailTimeStrategyUI.getScene());
	}
	
	public void setCheckThreeRoomsStrategyView(){
		checkThreeRoomsStrategyUI = new CheckThreeRoomsStrategy(this);
		checkThreeRoomsStrategyUI.setText();
		stage.setScene(checkThreeRoomsStrategyUI.getScene());
	}
	public void setChooseView(){
		stage.setScene(chooseUI.getScene());
	}
	
	public void setExistStrategy(){
		promotionId = null;
		setPromotionList();
		ExistStrategy existStrategyUI = new ExistStrategy(this);
		existStrategyUI.initialData();
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
	
	public void setPromotionList(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.ALL);
	}
	
	public ArrayList<PromotionVO> getPromotionList(){
		return promotionList;
	}
	
//	public void setRow(){
//		row = existStrategyUI.getRow();
//	}
//	
//	public int getRow(){
//		return row;
//	}
	
	public ResultMessage getPromotionResult(PromotionVO promotionVO){
		return promotionService.addPromotion(promotionVO);
	}
	
	public ResultMessage getDeletePromotionResult(int num){
		return promotionService.deletePromotion(promotionList.get(num).promotionID);
	}
	
	public void setDeletePromotion(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.ALL);
	}
	
	public void setPromotionId(int row){
		promotionId = promotionList.get(row).promotionID;
	}
	
	public PromotionVO getPromotionVO(){
		return promotionService.getPromotion(promotionId);
	}
}
