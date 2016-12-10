package viewController;

import javafx.stage.Stage;
import view.right.webBusiness.promotion.First;



public class WebBusinessLeftController {
	
	private WBVIPInfoController wbVIPInfoController;
	private WBOrderManagementController wbOrderManagementController;
	private WBPromotionController wbPromotionController;
	private WBCreditController wbCreditController;
	
	private First firstUI;
	
	protected Stage stage;
	
	public WebBusinessLeftController(){
		firstUI = new First(wbPromotionController);
	}
	
	public void setBlankView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbVIPInfoController = new WBVIPInfoController(newStage);
		wbVIPInfoController.setBlankView();
		newStage.show();
	}
	
	public void setWBCreditView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbCreditController = new WBCreditController(newStage);
		wbCreditController.setRechargeCreditView();
		newStage.show();
	}
	
	public void setAbnormalOrderView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbOrderManagementController = new WBOrderManagementController(newStage);
		wbOrderManagementController.setAbnormalOrderListView();
		newStage.show();
	}
	
	public void setWBVIPInfoView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbVIPInfoController = new WBVIPInfoController(newStage);
		wbVIPInfoController.setSetVIPCreditView();
		newStage.show();
	}
	
	public void setPromotionView(){
		stage = new Stage();
		stage.centerOnScreen();
		stage.setTitle("酒店预定系统");
		stage.setScene(firstUI.getScene());
		stage.show();
	}
	
	public void setTodayUnexecuteOrderView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbOrderManagementController = new WBOrderManagementController(newStage);
		wbOrderManagementController.setTodayUnexecuteOrderView();
		newStage.show();
	}
	
	public void setUnexecuteOrderView(){
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbOrderManagementController = new WBOrderManagementController(newStage);
		wbOrderManagementController.setUnexecuteOrderView();
		newStage.show();
	}
	
}
