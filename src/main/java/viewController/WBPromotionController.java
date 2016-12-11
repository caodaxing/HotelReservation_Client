package viewController;

import javafx.stage.Stage;
import logicService.promotion.PromotionService;
import view.right.webBusiness.promotion.CheckSpecialTimeStrategy;
import view.right.webBusiness.promotion.CheckVIPAreaStrategy;
import view.right.webBusiness.promotion.CheckVIPStrategy;
import view.right.webBusiness.promotion.Choose;
import view.right.webBusiness.promotion.ExistStrategy;
import view.right.webBusiness.promotion.First;
import view.right.webBusiness.promotion.SetSpecialTimeStrategy;
import view.right.webBusiness.promotion.SetVIPAreaStrategy;
import view.right.webBusiness.promotion.SetVIPStrategy;

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
	
	public WBPromotionController(Stage stage, String userId){
		
		//promotionService = new Promotion();
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
}
