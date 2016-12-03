package viewController;

import logicService.promotion.PromotionService;
import view.right.webBusiness.promotion.CheckSpecialTimeStrategy;
import view.right.webBusiness.promotion.CheckVIPAreaStrategy;
import view.right.webBusiness.promotion.CheckVIPStrategy;
import view.right.webBusiness.promotion.Choose;
import view.right.webBusiness.promotion.First;
import view.right.webBusiness.promotion.SetSpecialTimeStrategy;
import view.right.webBusiness.promotion.SetVIPAreaStrategy;
import view.right.webBusiness.promotion.SetVIPStrategy;

public class WBPromotionController {
	
	//逻辑层接口
	private PromotionService promotionService;
	
	//控制界面
	private CheckSpecialTimeStrategy checkSpecialTimeStrategyUI;
	private CheckVIPAreaStrategy checkVIPAreaStrategyUI;
	private CheckVIPStrategy checkVIPStrategyUI;
	private Choose chooseUI;
	private First firstUI;
	private SetSpecialTimeStrategy setSpecialTimeStrategyUI;
	private SetVIPAreaStrategy setVIPAreaStrategyUI;
	private SetVIPStrategy setVIPStrategyUI;
	
	public WBPromotionController(){
		//promotionService = new Promotion();
	}
	
	public void setView(First view){
		this.firstUI = view;
	}
}
