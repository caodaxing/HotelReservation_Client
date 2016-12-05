package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.right.webBusiness.orderManagement.AbnormalOrderList;
import viewController.WBOrderManagementController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
//		ExecuteOrder executeOrder = new ExecuteOrder(new UserMyOrderController());
//		
//		Scene scene = executeOrder.getScene();
		
		AbnormalOrderList abnormalOrderList = new AbnormalOrderList(new WBOrderManagementController());
		Scene scene = abnormalOrderList.getScene();
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
