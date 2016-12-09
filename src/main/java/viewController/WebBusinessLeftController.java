package viewController;

import javafx.stage.Stage;

public class WebBusinessLeftController {
	
	private WBVIPInfoController wbVIPInfoController;
	private WBOrderManagementController wbOrderManagementController;
	private WBPromotionController wbPromotionController;
	private WBCreditController wbCreditController;
	
	protected Stage stage;
	
	public WebBusinessLeftController(Stage stage){
		
		this.stage = stage;
		wbVIPInfoController = new WBVIPInfoController(stage);
		wbOrderManagementController = new WBOrderManagementController(stage);
		wbPromotionController = new WBPromotionController(stage);
		wbCreditController = new WBCreditController(stage);
		
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
		stage.close();
		Stage newStage = new Stage();
		newStage.centerOnScreen();
		newStage.setTitle("酒店预定系统");
		wbPromotionController = new WBPromotionController(newStage);
		wbPromotionController.setFirstView();
		newStage.show();
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
