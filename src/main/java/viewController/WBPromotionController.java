package viewController;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import javafx.stage.Stage;
import logic.hotel.SearchHotel;
import logic.promotion.ManagePromotion;
import logicService.hotel.SearchHotelService;
import logicService.promotion.ManagePromotionService;
import view.right.webBusiness.promotion.CheckSpecialTimeStrategy;
import view.right.webBusiness.promotion.CheckVIPAreaStrategy;
import view.right.webBusiness.promotion.CheckVIPStrategy;
import view.right.webBusiness.promotion.Choose;
import view.right.webBusiness.promotion.ExistStrategy;
import view.right.webBusiness.promotion.SetSpecialTimeStrategy;
import view.right.webBusiness.promotion.SetVIPAreaStrategy;
import view.right.webBusiness.promotion.SetVIPStrategy;
import vo.PromotionVO;

public class WBPromotionController extends WebBusinessLeftController{
	
	//逻辑层接口
	private ManagePromotionService promotionService;
	private SearchHotelService hotelSearchService;
	
	//控制界面
	private CheckSpecialTimeStrategy checkSpecialTimeStrategyUI;
	private CheckVIPAreaStrategy checkVIPAreaStrategyUI;
	private CheckVIPStrategy checkVIPStrategyUI;
	private Choose chooseUI;
	private ExistStrategy existStrategyUI;
	private SetSpecialTimeStrategy setSpecialTimeStrategyUI;
	private SetVIPAreaStrategy setVIPAreaStrategyUI;
	private SetVIPStrategy setVIPStrategyUI;
	
	private String promotionId;
	private ArrayList<PromotionVO> promotionList;
//	private int row;
	
	public WBPromotionController(Stage stage, String userId){
		
		super(stage,userId);
		promotionService = new ManagePromotion();
		hotelSearchService = new SearchHotel(); 
		checkSpecialTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkVIPAreaStrategyUI = new CheckVIPAreaStrategy(this);
		checkVIPStrategyUI  = new CheckVIPStrategy(this);
		chooseUI = new Choose(this);
		existStrategyUI = new ExistStrategy(this);
		setSpecialTimeStrategyUI = new SetSpecialTimeStrategy(this);
		setVIPAreaStrategyUI = new SetVIPAreaStrategy(this);
		setVIPStrategyUI = new SetVIPStrategy(this);
		
	}
	
//	public WBPromotionController(Stage stage, String userId, int row){
//		
//		super(stage,userId);
//		this.row = row;
//		promotionService = new ManagePromotion();
//		checkSpecialTimeStrategyUI = new CheckSpecialTimeStrategy(this);
//		checkVIPAreaStrategyUI = new CheckVIPAreaStrategy(this);
//		checkVIPStrategyUI  = new CheckVIPStrategy(this);
//		chooseUI = new Choose(this);
//		existStrategyUI = new ExistStrategy(this);
//		setSpecialTimeStrategyUI = new SetSpecialTimeStrategy(this);
//		setVIPAreaStrategyUI = new SetVIPAreaStrategy(this);
//		setVIPStrategyUI = new SetVIPStrategy(this);
//		
//	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckSpecialTimeStrategyView(){
		checkSpecialTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkSpecialTimeStrategyUI.setText();
		stage.setScene(checkSpecialTimeStrategyUI.getScene());
	}
	
	public void setCheckVIPAreaStrategyView(){
		stage.setScene(checkVIPAreaStrategyUI.getScene());
	}

	public void setCheckVIPStrategyView(){
		checkVIPStrategyUI  = new CheckVIPStrategy(this);
		checkVIPStrategyUI.setText();
		stage.setScene(checkVIPStrategyUI.getScene());
	}

	public void setChooseView(){
		stage.setScene(chooseUI.getScene());
	}
	
	public void setExistStrategyView(){
		promotionId = null;
		existStrategyUI = new ExistStrategy(this);
		existStrategyUI.initialData();
		stage.setScene(existStrategyUI.getScene());
	}

	public void setSetSpecialTimeStrategyView(){
		stage.setScene(setSpecialTimeStrategyUI.getScene());
	}

	public void setSetVIPAreaStrategyView(){
		stage.setScene(setVIPAreaStrategyUI.getScene());
	}
	
	public void setSetVIPStrategyView(){
		stage.setScene(setVIPStrategyUI.getScene());
	}
	
	public void setPromotoinList(){
		
		promotionList = promotionService.getWebPromotions(PromotionType.ALL);
	}
	
	public void setSpecialTimePromotion(){
		promotionList = promotionService.getWebPromotions(PromotionType.WEB_11_11);
	}
	
	public void setVipAreaPromotion(){
		promotionList = promotionService.getWebPromotions(PromotionType.WEB_VIP_TRADINGAREA);
	}

	public void setVipPromotion(){
		promotionList = promotionService.getWebPromotions(PromotionType.WEB_VIP_LEVEL);
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
	
	public ResultMessage getAddPromotionResult(PromotionVO promotionVO){
		return promotionService.addPromotion(promotionVO);
	}
	
	public ResultMessage getDeletePromotionResult(int num){
		return promotionService.deletePromotion(promotionList.get(num).promotionID);
	}
	
	public void setDeletePromotion(){
		promotionList = promotionService.getHotelPromotions(userId, PromotionType.ALL);
	}
	
	public ArrayList<String> getCityList(){
		return hotelSearchService.getCities();
	}
	
	public ArrayList<String> getTradingAreaList(String city){
		return hotelSearchService.getTradingArea(city);
	}
	
//	public ArrayList<PromotionVO> setPromotion(){
//		return promotionService.
//	}
	
//	public void setAllPromotion(){
//		promotionList = promotionService.getWebPromotions(PromotionType.ALL);
//	}
	
//	public ArrayList<PromotionVO> getAllPromotion(){
//		return promotionList;
//	}
	
	public void setPromotionId(int row){
		promotionId = promotionList.get(row).promotionID;
	}
	
	public String getPromotionId(){
		return promotionId;
	}
	
	public PromotionVO getPromotionVO(String promotionId){
		return promotionService.getPromotion(promotionId);
	}
}
