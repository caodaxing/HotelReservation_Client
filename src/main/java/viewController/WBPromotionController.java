package viewController;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.promotion.PromotionService;
import logicService.stub.PromotionService_Stub;
import view.right.webBusiness.promotion.CheckSpecialTimeStrategy;
import view.right.webBusiness.promotion.CheckVIPAreaStrategy;
import view.right.webBusiness.promotion.CheckVIPStrategy;
import view.right.webBusiness.promotion.Choose;
import view.right.webBusiness.promotion.ExistStrategy;
import view.right.webBusiness.promotion.SetSpecialTimeStrategy;
import view.right.webBusiness.promotion.SetVIPAreaStrategy;
import view.right.webBusiness.promotion.SetVIPStrategy;
import vo.CreditChangeVO;
import vo.PromotionVO;

public class WBPromotionController extends WebBusinessLeftController{
	
	//逻辑层接口
	private PromotionService promotionService;
	
	//控制界面
	private CheckSpecialTimeStrategy checkSpecialTimeStrategyUI;
	private CheckVIPAreaStrategy checkVIPAreaStrategyUI;
	private CheckVIPStrategy checkVIPStrategyUI;
	private Choose chooseUI;
	private ExistStrategy existStrategyUI;
	private SetSpecialTimeStrategy setSpecialTimeStrategyUI;
	private SetVIPAreaStrategy setVIPAreaStrategyUI;
	private SetVIPStrategy setVIPStrategyUI;
	
	private ArrayList<PromotionVO> promotionList;
	private int row;
	
	public WBPromotionController(Stage stage, String userId){
		
		promotionService = new PromotionService_Stub();
		this.stage = stage;
		this.userId = userId;
		checkSpecialTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkVIPAreaStrategyUI = new CheckVIPAreaStrategy(this);
		checkVIPStrategyUI  = new CheckVIPStrategy(this);
		chooseUI = new Choose(this);
		existStrategyUI = new ExistStrategy(this);
		setSpecialTimeStrategyUI = new SetSpecialTimeStrategy(this);
		setVIPAreaStrategyUI = new SetVIPAreaStrategy(this);
		setVIPStrategyUI = new SetVIPStrategy(this);
		
	}
	
	public WBPromotionController(Stage stage, String userId, int row){
		
		promotionService = new PromotionService_Stub();
		this.stage = stage;
		this.userId = userId;
		this.row = row;
		checkSpecialTimeStrategyUI = new CheckSpecialTimeStrategy(this);
		checkVIPAreaStrategyUI = new CheckVIPAreaStrategy(this);
		checkVIPStrategyUI  = new CheckVIPStrategy(this);
		chooseUI = new Choose(this);
		existStrategyUI = new ExistStrategy(this);
		setSpecialTimeStrategyUI = new SetSpecialTimeStrategy(this);
		setVIPAreaStrategyUI = new SetVIPAreaStrategy(this);
		setVIPStrategyUI = new SetVIPStrategy(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckSpecialTimeStrategyView(){
		stage.setScene(checkSpecialTimeStrategyUI.getScene());
	}
	
	public void setCheckVIPAreaStrategyView(){
		stage.setScene(checkVIPAreaStrategyUI.getScene());
	}

	public void setCheckVIPStrategyView(){
		stage.setScene(checkVIPStrategyUI.getScene());
	}

	public void setChooseView(){
		stage.setScene(chooseUI.getScene());
	}
	
	public void setExistStrategyView(){
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
	
	public void setRow(){
		row = existStrategyUI.getRow();
	}
	
	public int getRow(){
		return row;
	}
	
	
}
